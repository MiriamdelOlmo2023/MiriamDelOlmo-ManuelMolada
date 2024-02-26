package com.Proyecto.Package.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.Proyecto.Package.DAO.IDAOApuestasRuleta;
import com.Proyecto.Package.Entity.ApuestasRuletaEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class IDAOApuestasRuletaImpl implements IDAOApuestasRuleta {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(ApuestasRuletaEntity var) {
        try {
            em.persist(var);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    @Override
    public void merge(ApuestasRuletaEntity var) {
        try {
            em.merge(var);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    @Override
    public void remove(ApuestasRuletaEntity var) {
        try {
            em.remove(var);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public ApuestasRuletaEntity findById(Integer id) {
    	ApuestasRuletaEntity var = null;

        try {
            var = em.find(ApuestasRuletaEntity.class, id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return var;
    }
    
    @Override
    public List<ApuestasRuletaEntity> findAll() {
        List<ApuestasRuletaEntity> lst = null;
        TypedQuery<ApuestasRuletaEntity> query = null;

        try {
            query = em.createQuery("select a from ApuestasRuletaEntity a", ApuestasRuletaEntity.class);
            lst = query.getResultList();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lst;
    }
}
