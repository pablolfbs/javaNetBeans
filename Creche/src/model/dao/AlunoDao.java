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
        String sql = "INSERT INTO alunos VALUES (?, ?, ?, ?);";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, a.getId());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getDtNasc());
            ps.setString(4, a.getNomeMae());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void atualizar(Aluno a) {
        String sql = "UPDATE alunos SET nome = '" + a.getNome() + "', dtNasc = '" + a.getDtNasc() + "', nomeMae = '" + a.getNomeMae() + "' WHERE id = " + a.getId() + ";";
        
        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(Aluno a) {
        String sql = "DELETE FROM alunos WHERE id = " + a.getId() + ";";

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
        String sql = "SELECT * FROM alunos ORDER BY id;";

        Statement stmt;
        try {
            stmt = connection.createStatement();

            List<Aluno> alunos = new ArrayList<>();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));
                a.setDtNasc(rs.getString("dtNasc"));
                a.setNomeMae(rs.getString("nomeMae"));

                alunos.add(a);
            }
            rs.close();
            stmt.close();
            return alunos;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    
    public List<Aluno> listarPorNome() {
        String sql = "SELECT * FROM alunos ORDER BY nome;";

        Statement stmt;
        try {
            stmt = connection.createStatement();

            List<Aluno> alunos = new ArrayList<>();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));
                a.setDtNasc(rs.getString("dtNasc"));
                a.setNomeMae(rs.getString("nomeMae"));

                alunos.add(a);
            }
            rs.close();
            stmt.close();
            return alunos;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
