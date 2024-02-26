package com.Proyecto.Package.Service;

import java.util.List;

import com.Proyecto.Package.DTO.ApuestasGalgosDTO;

public interface IServiceApuestasGalgos{

	void crear(ApuestasGalgosDTO dto);

	void actualizar(ApuestasGalgosDTO dto);

	void eliminar(int id);

	ApuestasGalgosDTO buscarUno(int id);

	List<ApuestasGalgosDTO> buscaTodos();

}
