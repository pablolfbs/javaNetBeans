/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.AnuncioDAO;
import domain.Anuncio;
import java.util.List;

/**
 *
 * @author pablo
 */
public class AnuncioService {
    
    private AnuncioDAO db = new AnuncioDAO();

    public List<Anuncio> getListAnuncios() {
        try {
        	List<Anuncio> anuncios = db.getListAnuncios();
        	if (anuncios != null) {
				return anuncios;
			}
        	return null;
       	} catch (Exception e) {
               e.printStackTrace();
        }
		return null;
    }
}
