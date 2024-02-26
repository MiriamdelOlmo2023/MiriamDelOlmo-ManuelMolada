package com.Proyecto.Package.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "APUESTAS_RULETA")
public class ApuestasRuletaEntity implements Serializable{

private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secuencia")
	@SequenceGenerator(name = "secuencia",allocationSize = 1,sequenceName = "SEQ_APUESTASRULETA")
	@Id
	@Column(name="ID_APUESTA_RULETA")
	private int idApuestaRuleta;
	
	@Column(name="FECHA")
	private String fecha;
	
	@Column(name="APOSTADO")
	private int apostado;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private UsuarioEntity usuario;

	public ApuestasRuletaEntity() {
		
	}
	
	public ApuestasRuletaEntity(int idApuestaRuleta, String fecha, int apostado, UsuarioEntity usuario) {
		super();
		this.idApuestaRuleta = idApuestaRuleta;
		this.fecha = fecha;
		this.apostado = apostado;
		this.usuario = usuario;
	}

	public int getIdApuestaRuleta() {
		return idApuestaRuleta;
	}

	public void setIdApuestaRuleta(int idApuestaRuleta) {
		this.idApuestaRuleta = idApuestaRuleta;
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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
}

