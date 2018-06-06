
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Connection connection;

    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrar(Aluno aluno) {
        
        String sql = "INSERT INTO alunos (nome, dtNascimento, nomeMae) VALUES ( ?, ?, ?);";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getDtNascimento());
            stmt.setString(3, aluno.getNomeMae());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
