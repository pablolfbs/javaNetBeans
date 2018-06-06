/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Anuncio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class AnuncioDAO extends BaseDAO {
    
    public Anuncio createAnuncio(ResultSet rs) throws SQLException{
		Anuncio a = new Anuncio();
		a.setId(rs.getInt("anuncio_id"));
		a.setDataSaida(rs.getString("anuncio_data"));
		a.setNome(rs.getString("anuncio_nome"));
		a.setDescricao(rs.getString("anuncio_descricao"));
		a.setPreco(rs.getString("anuncio_preco"));

		return a;
	}
	
	public List<Anuncio> getListAnuncios() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Anuncio> anuncios = new ArrayList<>();
		try{
			conn=getConnection();
			stmt = conn.prepareStatement("select * from anuncio");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Anuncio a = createAnuncio(rs);
				anuncios.add(a);				
			}
			rs.close();
		}finally{
			if(stmt !=null){
				stmt.close();
			}
			if(conn !=null){
				conn.close();
			}			
		}
		return anuncios;
	}
}
