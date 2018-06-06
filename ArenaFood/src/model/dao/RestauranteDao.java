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
import model.Restaurante;

/**
 *
 * @author Pablo
 */
public class RestauranteDao {

    public Connection connection;

    public RestauranteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrar(Restaurante restaurante) {
        String sql = "INSERT INTO restaurantes (tipo, nome, endereco, contato) VALUES (?, ?, ?, ?);";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, restaurante.getTipo());
            ps.setString(2, restaurante.getNome());
            ps.setString(3, restaurante.getEndereco());
            ps.setString(4, restaurante.getContato());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Restaurante restaurante) {
        String sql = "DELETE FROM restaurantes WHERE id = " + restaurante.getId() + ";";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void atualizar(Restaurante restaurante) {
        String sql = "UPDATE restaurantes SET (tipo = ?, nome = ?, endereco = ?, contato = ?) WHERE (id = ?);";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, restaurante.getTipo());
            ps.setString(2, restaurante.getNome());
            ps.setString(3, restaurante.getEndereco());
            ps.setString(4, restaurante.getContato());
            ps.setInt(5, restaurante.getId());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Restaurante> buscarPorNome(String nome) {
        String sql = "SELECT * FROM restaurantes WHERE nome LIKE '%" + nome + "%';";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Restaurante> restaurantes = new ArrayList<>();

            while (rs.next()) {
                Restaurante restaurante = new Restaurante();
                restaurante.setId(rs.getInt("id"));
                restaurante.setTipo(rs.getString("tipo"));
                restaurante.setNome(rs.getString("nome"));
                restaurante.setEndereco(rs.getString("endereco"));
                restaurante.setContato(rs.getString("contato"));

                restaurantes.add(restaurante);
            }
            stmt.close();
            return restaurantes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Restaurante> listar() {
        String sql = "SELECT * FROM restaurantes;";

        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Restaurante> restaurantes = new ArrayList<>();

            while (rs.next()) {
                Restaurante r = new Restaurante();
                r.setId(rs.getInt("id"));
                r.setTipo(rs.getString("tipo"));
                r.setNome(rs.getString("nome"));
                r.setEndereco(rs.getString("endereco"));
                r.setContato(rs.getString("contato"));

                restaurantes.add(r);
            }
            stmt.close();
            return restaurantes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
