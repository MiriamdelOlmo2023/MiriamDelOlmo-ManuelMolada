package com.Proyecto.Package.DTO;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int idUsuario;
	private String username;
	private String password;
	private int fichas;
	private String email;
	
	
	public UsuarioDTO() {

	}
	
	
	public UsuarioDTO(int idUsuario, String username, String password, int fichas, String email) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.fichas = fichas;
		this.email = email;
	}
	

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getFichas() {
		return fichas;
	}
	
	public void setFichas(int fichas) {
		this.fichas = fichas;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
