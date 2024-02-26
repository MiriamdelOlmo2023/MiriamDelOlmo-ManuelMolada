package com.Proyecto.Package.DTO;

import java.io.Serializable;

public class ApuestasGalgosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idApuestaGalgos;
	private String fecha;
	private int apostado;
	private String circuito;
	private String galgo;
	private UsuarioDTO usuario;
	
	public ApuestasGalgosDTO() {
		
	}
	
	
	public ApuestasGalgosDTO(int idApuestaGalgos, String fecha, int apostado, String circuito, String galgo,
			UsuarioDTO usuario) {
		super();
		this.idApuestaGalgos = idApuestaGalgos;
		this.fecha = fecha;
		this.apostado = apostado;
		this.circuito = circuito;
		this.galgo = galgo;
		this.usuario = usuario;
	}

	public int getIdApuestaGalgos() {
		return idApuestaGalgos;
	}
	
	public void setIdApuestaGalgos(int idApuestaGalgos) {
		this.idApuestaGalgos = idApuestaGalgos;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getApostado() {
		return apostado;
	}
	
	public void setApostado(int apostado) {
		this.apostado = apostado;
	}
	
	public String getCircuito() {
		return circuito;
	}
	
	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}
	
	public String getGalgo() {
		return galgo;
	}
	
	public void setGalgo(String galgo) {
		this.galgo = galgo;
	}
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}
