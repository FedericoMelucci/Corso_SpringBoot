package com.example.demo_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo_2.entity.Persona;

@org.springframework.stereotype.Service
public class Service1 {
    

    @Autowired
    Repository1 rep;

    public List<Persona> getPersonaService() {
        return rep.getPersonaRepository(); 
    }


    public Persona inserisciPersonaService(Persona persona) {

        return rep.inserisciPersonaRep(persona);
    }

    public Persona modificaPersonaService(Persona persona) {

        return rep.modificaPersonaRep(persona);
    }

    public Persona rimuoviPersonaService(Persona persona) {

        return rep.rimuoviPersonaRep(persona);
    }

}
