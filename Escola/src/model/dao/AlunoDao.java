package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pablo
 */
public class AlunoDao {

    private Connection connection;

    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserir(String nome, String cpf, String endereco, String contato) {
        String sql = "INSERT INTO alunos (nome, cpf, endereco, contato) VALUES ('" + nome + "', '" + cpf + "', '" + endereco + "', '" + contato + "');";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(String nome, String cpf, String endereco, String contato) {
        String sql = "UPDATE alunos SET nome = '" + nome + "', cpf = '" + cpf + "', endereco = '" + endereco + "', contato = '" + contato + "' WHERE nome = '" + nome + "';";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int matricula) {
        String sql = "DELETE FROM alunos WHERE matricula = " + matricula + ";";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Aluno> buscarPorMatricula(int matricula) {
        String sql = "SELECT * FROM alunos WHERE matricula = " + matricula + "";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Aluno> alunos = new ArrayList<>();

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setEndereco(rs.getString("endereco"));
                a.setContato(rs.getString("contato"));
                alunos.add(a);
            }
            stmt.close();
            return alunos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Aluno> buscarPorNome(String nome) {
        String sql = "SELECT * FROM alunos WHERE nome LIKE '%" + nome + "%';";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Aluno> alunos = new ArrayList<>();
            
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setEndereco(rs.getString("endereco"));
                a.setContato(rs.getString("contato"));
                alunos.add(a);
            }
            stmt.close();
            return alunos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Aluno> listar() {
        String sql = "SELECT * FROM alunos;";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Aluno> alunos = new ArrayList<>();

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setEndereco(rs.getString("endereco"));
                a.setContato(rs.getString("contato"));
                alunos.add(a);
            }
            stmt.close();
            return alunos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
