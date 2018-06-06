/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

/**
 *
 * @author Pablo
 */
public class AlunoDao {

    public Connection connection;

    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserir(Aluno a) {
        String sql = "INSERT INTO aluno (codigo, nome, cpf) VALUES (?, ?, ?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, a.getCodigo());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(Aluno a) {
        String sql = "UPDATE aluno SET nome = '" + a.getNome() + "', cpf = '" + a.getCpf() + "' WHERE codigo = " + a.getCodigo() + ";";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(Aluno a) {
        String sql = "DELETE FROM aluno WHERE codigo = " + a.getCodigo() + ";";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Aluno> listar() {
        String sql = "SELECT * FROM aluno ORDER BY codigo;";

        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);

            List<Aluno> alunos = new ArrayList<>();

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setCodigo(rs.getInt("codigo"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                alunos.add(a);
            }
            stmt.close();
            return alunos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
