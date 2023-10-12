package com.hibernate_prova.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hibernate_prova.entity.Corso;

@Repository
public class CorsoRepository {

    @PersistenceContext
    EntityManager entityManager;


    public List<Corso> getListaCorsi() {
        
        javax.persistence.Query q= entityManager.createQuery("SELECT u FROM Corso u");

        return q.getResultList();

    }


}
