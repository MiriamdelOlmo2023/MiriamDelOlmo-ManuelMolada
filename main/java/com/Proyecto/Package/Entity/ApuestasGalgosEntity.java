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
@Table(name = "APUESTAS_GALGOS")
public class ApuestasGalgosEntity implements Serializable{

private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secuencia")
	@SequenceGenerator(name = "secuencia",allocationSize = 1,sequenceName = "SEQ_APUESTASGALGOS")
	@Id
	@Column(name="ID_APUESTA_GALGOS")
	private int idApuestaGalgos;
	
	@Column(name="FECHA")
	private String fecha;
	
	@Column(name="APOSTADO")
	private int apostado;
	
	@Column(name="CIRCUITO")
	private String circuito;
	
	@Column(name="GALGO")
	private String galgo;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private UsuarioEntity usuario;

	public ApuestasGalgosEntity() {
		
	}
	
	public ApuestasGalgosEntity(int idApuestaGalgos, String fecha, int apostado, String circuito, String galgo,
			UsuarioEntity usuario) {
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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
}

