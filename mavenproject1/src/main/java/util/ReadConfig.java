/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author pablo
 */
public class ReadConfig {
    
    private String jdbc_username;
	private String jdbc_password;
	private String jdbc_url;
	
	public ReadConfig(){
		try {
			this.getParam();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}
	
	private void getParam() {
		this.jdbc_username = "senac3";
		this.jdbc_password = "123";
		this.jdbc_url = "jdbc:mysql://localhost:3306/senac";
	}

	public String getJdbc_username() {
		return jdbc_username;
	}
	
	public void setJdbc_username(String jdbc_username) {
		this.jdbc_username = jdbc_username;
	}
	
	public String getJdbc_password() {
		return jdbc_password;
	}
	
	public void setJdbc_password(String jdbc_password) {
		this.jdbc_password = jdbc_password;
	}
	
	public String getJdbc_url() {
		return jdbc_url;
	}
	
	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}
    
}
