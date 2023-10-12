package com.hibernate_prova.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hibernate_prova.dto.PersonaDto;
import com.hibernate_prova.entity.Persona;


@Repository
public class PersonaRepositoryImp implements PersonaRepository{


    /* Questa annotazione serve per poter interrogare il database, creando una istanza dell'entity manager, quindi spring andrà a pescare i bean di entity manager*/
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Persona> getPersonaList() {
        
        /* con questa sintassi si potranno effettuare le query al database, Persona con la P maiuscola si intende la classe mappata e non la tabella del database */
        javax.persistence.Query q= entityManager.createQuery("SELECT u FROM Persona u");
        return q.getResultList();
    }


    @Override
    @Transactional /* Serve per poter far effettuare a hibernate il roll back */
    public Persona insertPersona(PersonaDto persona) {

        Persona entity= new Persona(persona);
        entityManager.persist(entity);
        return entity;
    }


    @Override
    @Transactional
    public Persona updatePersona(PersonaDto persona) {
        
        Persona entity= new Persona(persona);

        return entityManager.merge(entity); /* merge ci servirà per aggiornare */
    }


    @Override
    @Transactional
    public Persona deletePersona(PersonaDto persona) {

        Persona p= entityManager.find(Persona.class, persona.getId()); /* questo sarà utile per avere un punto di riferimento su cui si andrà poi ad effettuare la chiamata del metodo vale a dire del delete. */

        entityManager.remove(p); /* con il comando .remove si rimuoverà quell'elemento */
        
        Persona entity= new Persona(persona);
        

        return entity;
    }


    @Override
    @Transactional
    public List<Persona> findPersonaByName(String nome) {
        
         javax.persistence.Query q= entityManager.createQuery("SELECT u FROM Persona u WHERE u.nome= :nome"); /* u.nome= :nome è una sintassi che serve per dare al valore nome il valore che inseriremo */
        
        return q.setParameter("nome", nome).getResultList();
    }
    
}
