package com.Proyecto.Package.DTO;

import java.io.Serializable;

public class ApuestasRuletaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idApuestaRuleta;
	private String fecha;
	private int apostado;
	private UsuarioDTO usuario;
	
	public ApuestasRuletaDTO() {
		
	}
	
	
	public ApuestasRuletaDTO(int idApuestaRuleta, String fecha, int apostado, UsuarioDTO usuario) {
		super();
		this.idApuestaRuleta = idApuestaRuleta;
		this.fecha = fecha;
		this.apostado = apostado;
		this.usuario = usuario;
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
	
	public int getIdApuestaRuleta() {
		return idApuestaRuleta;
	}


	public void setIdApuestaRuleta(int idApuestaRuleta) {
		this.idApuestaRuleta = idApuestaRuleta;
	}


	public UsuarioDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}
