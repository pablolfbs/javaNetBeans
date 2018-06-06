/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 36115142016.2N
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Produto {

    String db = "jdbc:mysql://127.0.0.1/estoque";

    Connection conexao;
    Statement stmt;

    int codigo;
    String nome;
    int quantidade;

    String instrucao;

    void conectar() {
        try {
            conexao = DriverManager.getConnection(db, "root", "");
            stmt = conexao.createStatement();
            System.out.println("CONECTOU");
        } catch (SQLException ex) {
            System.out.println("FALHA");
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
    ArrayList<Produto> listar() {
        ArrayList<Produto> produtos = new ArrayList<>();

        instrucao = "SELECT * FROM produto;";

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

    @Override
    public String toString() {
        return this.codigo + " - " + this.nome + " - " + this.quantidade;
    }

    void atualizar() {
        String instrucao;

        instrucao = "UPDATE produto SET nome = '" + this.nome + "', quantidade = " + this.quantidade + " WHERE codigo = " + this.codigo + ";";
        
        try {
            stmt.execute(instrucao);
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void excluir(int cod) {
        instrucao = "DELETE FROM produto WHERE codigo = " + cod + ";";
        try {
            stmt.execute(instrucao);
        } catch (SQLException ex) {
            System.out.println("FALHA");
        }
    }

    void desconectar() {
        try {
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("FALHA");
        }
    }
}
