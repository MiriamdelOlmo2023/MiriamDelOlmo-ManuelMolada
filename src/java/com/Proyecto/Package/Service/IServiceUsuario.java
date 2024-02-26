package com.Proyecto.Package.Service;

import java.util.List;

import com.Proyecto.Package.DTO.UsuarioDTO;

public interface IServiceUsuario {

	public boolean login(String username, String password);
	
	void guardar(UsuarioDTO usuario);

	void eliminar(int id);

	List<UsuarioDTO> findAll();

	void modificar(UsuarioDTO usuario);

	UsuarioDTO findById(int id);
	
	public boolean register(String username, String password, String email);
	
	public UsuarioDTO obtenerDTO(String usuario, String password);

}
