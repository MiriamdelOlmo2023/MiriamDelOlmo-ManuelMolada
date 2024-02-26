package com.Proyecto.Package.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.Package.DAO.IDAOApuestasGalgos;
import com.Proyecto.Package.DTO.ApuestasGalgosDTO;
import com.Proyecto.Package.DTO.UsuarioDTO;
import com.Proyecto.Package.Entity.ApuestasGalgosEntity;
import com.Proyecto.Package.Entity.UsuarioEntity;
import com.Proyecto.Package.Service.IServiceApuestasGalgos;

@Service
public class IServiceApuestasGalgosImpl implements IServiceApuestasGalgos {
	
	@Autowired
	private IDAOApuestasGalgos dao;
	
	@Override
	@Transactional
	public void crear(ApuestasGalgosDTO dto) {
		
		ApuestasGalgosEntity nuevo = null;
		UsuarioEntity user = null;
		
		try {
			
			if(dto != null) {
				nuevo = new ApuestasGalgosEntity();
				nuevo.setIdApuestaGalgos(dto.getIdApuestaGalgos());
				
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
				nuevo.setCircuito(dto.getCircuito());
				nuevo.setGalgo(dto.getGalgo());
				
				dao.save(nuevo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public void actualizar(ApuestasGalgosDTO dto) {	
		
		ApuestasGalgosEntity nuevo = null;
		UsuarioEntity user = null;
		try {
			
			if(dto != null) {
				nuevo = new ApuestasGalgosEntity();
				nuevo.setIdApuestaGalgos(dto.getIdApuestaGalgos());
				
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
				nuevo.setCircuito(dto.getCircuito());
				nuevo.setGalgo(dto.getGalgo());
				
				dao.save(nuevo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	@Transactional
	public void eliminar(int id) {
		
		ApuestasGalgosEntity nuevo = null;

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
	public ApuestasGalgosDTO buscarUno(int id) {
		ApuestasGalgosDTO nuevo = null;
		ApuestasGalgosEntity entidad = null;
		UsuarioDTO user = null;

		try {
			entidad=dao.findById(id);
			
			if(entidad!=null) {
				nuevo = new ApuestasGalgosDTO();
				nuevo.setIdApuestaGalgos(entidad.getIdApuestaGalgos());
				
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
				nuevo.setCircuito(entidad.getCircuito());
				nuevo.setGalgo(entidad.getGalgo());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return nuevo;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ApuestasGalgosDTO> buscaTodos() {
		ApuestasGalgosDTO nuevo = null;
		List<ApuestasGalgosDTO> lista = null;
		List<ApuestasGalgosEntity> listaE = null;
		UsuarioDTO user = null;
		
		try {
			listaE = new ArrayList<>();
			lista = new ArrayList<>();
			listaE= dao.findAll();
			
			for(ApuestasGalgosEntity entidad: listaE) {
				nuevo = new ApuestasGalgosDTO();
				nuevo.setIdApuestaGalgos(entidad.getIdApuestaGalgos());
				
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
				nuevo.setCircuito(entidad.getCircuito());
				nuevo.setGalgo(entidad.getGalgo());
				lista.add(nuevo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
