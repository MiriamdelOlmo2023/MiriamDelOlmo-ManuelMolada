package com.Proyecto.Package.DAO;

import java.util.List;

import com.Proyecto.Package.Entity.ApuestasRuletaEntity;

public interface IDAOApuestasRuleta {

	void save(ApuestasRuletaEntity var);

	void merge(ApuestasRuletaEntity var);

	void remove(ApuestasRuletaEntity var);

	ApuestasRuletaEntity findById(Integer id);

	List<ApuestasRuletaEntity> findAll();

}
