/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Periceles.Vianna
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Produto {

    String baseDeDados = "jdbc:mysql://127.0.0.1:3306/estoque";

    int codigo;
    String nome;
    int quantidade;

    Connection conexao;
    Statement stmt;

    Produto() {

        try {
            conexao = DriverManager.getConnection(baseDeDados, "root", "");
            stmt = conexao.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void cadastrar() {
        String instrucao;

        instrucao = "insert into produto values ( " + this.codigo + " , '" + this.nome + "'  , " + this.quantidade + " );";
        try {
            stmt.execute(instrucao);
            JOptionPane.showMessageDialog(null, "SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FALHA: " + ex.toString());
        }
    }

    void atualizar() {
        String instrucao;

        instrucao = " UPDATE produto SET nome = '" + this.nome + "', quantidade = " + this.quantidade + " where codigo = " + this.codigo + ";";

        try {
            stmt.execute(instrucao);
            JOptionPane.showMessageDialog(null, "SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FALHA: " + ex.toString());
        }
    }

    void excluir(int codigo) {
        String instrucao;

        instrucao = "delete from produto WHERE codigo = " + codigo;
        try {
            //JOptionPane.showMessageDialog(null, instrucao);
            stmt.execute(instrucao);
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Produto> listar() {
        String instrucao;

        instrucao = "SELECT * FROM produto;";
        
        List<Produto> produtos = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery(instrucao);
            while (rs.next()) {
                Produto p = new Produto();
                p.codigo = rs.getInt(1);
                p.nome = rs.getString(2);
                p.quantidade = rs.getInt(3);
                produtos.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("FALHA");
        }
        return produtos;
    }

    void buscarPorCodigo() {
        String instrucao;
        
        instrucao = "select * from produto" + "WHERE codigo = " + codigo;
        
        try {
            ResultSet rs = stmt.executeQuery(instrucao);
            
            while (rs.next()) {                
                System.out.println(rs.getString(nome) + ", " + rs.getString(quantidade));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void desconectar() {
        try {
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
