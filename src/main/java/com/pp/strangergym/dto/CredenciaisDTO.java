package com.pp.strangergym.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String login;
	
	private String password;
	
	public CredenciaisDTO() {
		
	}
	
	public CredenciaisDTO(String login, String senha) {
		super();
		this.login = login;
		this.password = senha;
	}
	public String getEmail() {
		return login;
	}
	public void setEmail(String email) {
		this.login = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

