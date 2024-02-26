package com.Proyecto.Package.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.Package.DAO.IDAOApuestasRuleta;
import com.Proyecto.Package.DTO.ApuestasRuletaDTO;
import com.Proyecto.Package.DTO.UsuarioDTO;
import com.Proyecto.Package.Entity.ApuestasRuletaEntity;
import com.Proyecto.Package.Entity.UsuarioEntity;
import com.Proyecto.Package.Service.IServiceApuestasRuleta;

@Service
public class IServiceApuestasRuletaImpl implements IServiceApuestasRuleta {
	
	@Autowired
	private IDAOApuestasRuleta dao;
	
	@Override
	@Transactional
	public void crear(ApuestasRuletaDTO dto) {
		
		ApuestasRuletaEntity nuevo = null;
		UsuarioEntity user = null;
		
		try {
			
			if(dto != null) {
				nuevo = new ApuestasRuletaEntity();
				nuevo.setIdApuestaRuleta(dto.getIdApuestaRuleta());
				
				if(dto.getUsuario() != null) {
					//USUARIO
					user = new UsuarioEntity();
					user.setIdUsuario(dto.getUsuario().getIdUsuario());
					user.setUsername(dto.getUsuario().getUsername());
					user.setPassword(dto.getUsuario().getPassword());
					user.setFichas(dto.getUsuario().getFichas());
					user.setEmail(dto.getUsuario().getEmail());
					
					nuevo.setUsuario(user);
				}
				
				nuevo.setFecha(dto.getFecha());
				nuevo.setApostado(dto.getApostado());
				
				dao.save(nuevo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public void actualizar(ApuestasRuletaDTO dto) {	
		
		ApuestasRuletaEntity nuevo = null;
		UsuarioEntity user = null;
		try {
			
			if(dto != null) {
				nuevo = new ApuestasRuletaEntity();
				nuevo.setIdApuestaRuleta(dto.getIdApuestaRuleta());
				
				if(dto.getUsuario() != null) {
					//USUARIO
					user = new UsuarioEntity();
					user.setIdUsuario(dto.getUsuario().getIdUsuario());
					user.setUsername(dto.getUsuario().getUsername());
					user.setPassword(dto.getUsuario().getPassword());
					user.setFichas(dto.getUsuario().getFichas());
					user.setEmail(dto.getUsuario().getEmail());
					
					nuevo.setUsuario(user);
				}
				
				nuevo.setFecha(dto.getFecha());
				nuevo.setApostado(dto.getApostado());
				
				dao.save(nuevo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	@Transactional
	public void eliminar(int id) {
		
		ApuestasRuletaEntity nuevo = null;

		try {
			nuevo = dao.findById(id);
			
			if(nuevo!=null) {
				dao.remove(nuevo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	@Override
	@Transactional(readOnly = true)
	public ApuestasRuletaDTO buscarUno(int id) {
		ApuestasRuletaDTO nuevo = null;
		ApuestasRuletaEntity entidad = null;
		UsuarioDTO user = null;

		try {
			entidad=dao.findById(id);
			
			if(entidad!=null) {
				nuevo = new ApuestasRuletaDTO();
				nuevo.setIdApuestaRuleta(entidad.getIdApuestaRuleta());
				
				if(entidad.getUsuario() != null) {
					//USUARIO
					user = new UsuarioDTO();
					user.setIdUsuario(entidad.getUsuario().getIdUsuario());
					user.setUsername(entidad.getUsuario().getUsername());
					user.setPassword(entidad.getUsuario().getPassword());
					user.setFichas(entidad.getUsuario().getFichas());
					user.setEmail(entidad.getUsuario().getEmail());
					
					nuevo.setUsuario(user);
				}
				
				nuevo.setFecha(entidad.getFecha());
				nuevo.setApostado(entidad.getApostado());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return nuevo;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ApuestasRuletaDTO> buscaTodos() {
		ApuestasRuletaDTO nuevo = null;
		List<ApuestasRuletaDTO> lista = null;
		List<ApuestasRuletaEntity> listaE = null;
		UsuarioDTO user = null;
		
		try {
			listaE = new ArrayList<>();
			lista = new ArrayList<>();
			listaE= dao.findAll();
			
			for(ApuestasRuletaEntity entidad: listaE) {
				nuevo = new ApuestasRuletaDTO();
				nuevo.setIdApuestaRuleta(entidad.getIdApuestaRuleta());
				
				if(entidad.getUsuario() != null) {
					//USUARIO
					user = new UsuarioDTO();
					user.setIdUsuario(entidad.getUsuario().getIdUsuario());
					user.setUsername(entidad.getUsuario().getUsername());
					user.setPassword(entidad.getUsuario().getPassword());
					user.setFichas(entidad.getUsuario().getFichas());
					user.setEmail(entidad.getUsuario().getEmail());
					
					nuevo.setUsuario(user);
				}
				
				nuevo.setFecha(entidad.getFecha());
				nuevo.setApostado(entidad.getApostado());
				lista.add(nuevo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
