package com.Proyecto.Package.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secuencia")
	@SequenceGenerator(name = "secuencia",allocationSize = 1,sequenceName = "SEQ_USUARIOCASINO")
	@Id
	@Column(name="ID_USUARIO")
	private int idUsuario;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FICHAS")
	private int fichas;
	
	@Column(name="EMAIL")
	private String email;
	
	public UsuarioEntity() {
		
	}

	public UsuarioEntity(int idUsuario, String username, String password, int fichas, String email) {
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
