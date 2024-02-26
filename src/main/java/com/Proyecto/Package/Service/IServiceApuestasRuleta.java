package com.Proyecto.Package.Service;

import java.util.List;

import com.Proyecto.Package.DTO.ApuestasRuletaDTO;

public interface IServiceApuestasRuleta{

	void crear(ApuestasRuletaDTO dto);

	void actualizar(ApuestasRuletaDTO dto);

	void eliminar(int id);

	ApuestasRuletaDTO buscarUno(int id);

	List<ApuestasRuletaDTO> buscaTodos();

}
