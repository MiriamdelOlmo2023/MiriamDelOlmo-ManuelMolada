package com.Proyecto.Package.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Proyecto.Package.DAO.IDAOApuestasGalgos;
import com.Proyecto.Package.Entity.ApuestasGalgosEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class IDAOApuestasGalgosImpl implements IDAOApuestasGalgos {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(ApuestasGalgosEntity var) {
        try {
            em.persist(var);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    @Override
    public void merge(ApuestasGalgosEntity var) {
        try {
            em.merge(var);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    @Override
    public void remove(ApuestasGalgosEntity var) {
        try {
            em.remove(var);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public ApuestasGalgosEntity findById(Integer id) {
    	ApuestasGalgosEntity var = null;

        try {
            var = em.find(ApuestasGalgosEntity.class, id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return var;
    }
    
    @Override
    public List<ApuestasGalgosEntity> findAll() {
        List<ApuestasGalgosEntity> lst = null;
        TypedQuery<ApuestasGalgosEntity> query = null;

        try {
            query = em.createQuery("select a from ApuestasGalgosEntity a", ApuestasGalgosEntity.class);
            lst = query.getResultList();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lst;
    }
}
