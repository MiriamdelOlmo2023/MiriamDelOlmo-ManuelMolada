package com.Proyecto.Package.Service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.Package.DAO.IDAOUsuario;
import com.Proyecto.Package.DTO.UsuarioDTO;
import com.Proyecto.Package.Entity.UsuarioEntity;
import com.Proyecto.Package.Service.IServiceUsuario;

@Service
public class IServiceUsuarioImpl implements IServiceUsuario {

	@Autowired
	private IDAOUsuario dao;
	
	
	public boolean login(String username, String password) {
		boolean isLogged = false;
		List<UsuarioDTO> lstUsuarios = this.findAll();
		UsuarioDTO usuario = lstUsuarios.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst().orElse(null);
		
		if(usuario != null) {
			isLogged = true;
		}
		
		return isLogged;
	}
	
	public boolean register(String username, String password, String email) {
		boolean isRegistered = false;
		
		List<UsuarioDTO> lstUsuarios = this.findAll();
		UsuarioDTO comprobar = lstUsuarios.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst().orElse(null);
		
		if(comprobar == null) {
			
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setUsername(username);
			usuario.setPassword(password);
			usuario.setEmail(email);
			
			try {
				guardar(usuario);
				
				if(usuario != null) {
					isRegistered = true;
					
			    }
			} catch (Exception e) {
				
			}
		}
		
		return isRegistered;
	}
	
	public UsuarioDTO obtenerDTO(String usuario, String password) {
		
		List<UsuarioDTO> lstUsuarios = this.findAll();
		UsuarioDTO dto = lstUsuarios.stream().filter(u -> u.getUsername().equals(usuario) && u.getPassword().equals(password)).findFirst().orElse(null);
		
		return dto;
	}
	
	
	@Override
	public void guardar(UsuarioDTO usuario) {
		
		UsuarioEntity entidad = null;
		
		try {
			entidad = new UsuarioEntity();
			entidad.setIdUsuario(usuario.getIdUsuario());
			entidad.setUsername(usuario.getUsername());
			entidad.setPassword(usuario.getPassword());
			entidad.setFichas(usuario.getFichas());
			entidad.setEmail(usuario.getEmail());
			
			dao.save(entidad);
			
		} catch (Exception e) {
            System.out.println(e.getMessage());
        }	
	}
	
	@Override
    public void modificar(UsuarioDTO usuario) {
        try {
        	UsuarioEntity entidad = dao.findById(String.valueOf(usuario.getIdUsuario())).orElse(null);

            if (entidad != null) {
    			entidad.setUsername(usuario.getUsername());
    			entidad.setPassword(usuario.getPassword());
    			entidad.setFichas(usuario.getFichas());
    			entidad.setEmail(usuario.getEmail());

                dao.save(entidad);
            } else {
                System.out.println("La entidad no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	@Override
    public void eliminar(int id) {
		UsuarioEntity entidad = null;
        try {
            entidad = dao.findById(String.valueOf(id)).orElse(null);
            if (entidad != null) {
                dao.delete(entidad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	 @Override
	    public List<UsuarioDTO> findAll() {
	        List<UsuarioDTO> lstResultado = null;
	        Iterable<UsuarioEntity> lstEntidades = null;

	        try {
	            lstResultado = new ArrayList<>();
	            lstEntidades = dao.findAll();

	            for (Iterator<UsuarioEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
	            	UsuarioEntity entity = iterator.next();
	            	UsuarioDTO actual = new UsuarioDTO();
	                actual.setIdUsuario(entity.getIdUsuario());
	                actual.setUsername(entity.getUsername());
	                actual.setPassword(entity.getPassword());
	                actual.setFichas(entity.getFichas());
	                actual.setEmail(entity.getEmail());
	                
	                lstResultado.add(actual);
	            }

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        return lstResultado;
	    }

	 
	 @Override
    public UsuarioDTO findById(int id) {
		 UsuarioDTO actual = new UsuarioDTO();
		 UsuarioEntity entity = null;
        try {
            entity = dao.findById(String.valueOf(id)).orElse(null);
            if (entity != null) {
            	actual.setIdUsuario(entity.getIdUsuario());
                actual.setUsername(entity.getUsername());
                actual.setPassword(entity.getPassword());
                actual.setFichas(entity.getFichas());
                actual.setEmail(entity.getEmail());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

	        return actual;
	    }
	
}
