package com.Proyecto.Package.DAO;

import java.util.List;

import com.Proyecto.Package.Entity.ApuestasGalgosEntity;

public interface IDAOApuestasGalgos {

	void save(ApuestasGalgosEntity var);

	void merge(ApuestasGalgosEntity var);

	void remove(ApuestasGalgosEntity var);

	ApuestasGalgosEntity findById(Integer id);

	List<ApuestasGalgosEntity> findAll();

}
