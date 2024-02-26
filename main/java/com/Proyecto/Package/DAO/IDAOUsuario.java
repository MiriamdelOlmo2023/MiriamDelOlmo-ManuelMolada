package com.Proyecto.Package.DAO;

import org.springframework.data.repository.CrudRepository;

import com.Proyecto.Package.Entity.UsuarioEntity;

public interface IDAOUsuario  extends CrudRepository<UsuarioEntity, String>{

}
