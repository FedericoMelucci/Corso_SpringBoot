package com.hibernate_prova.repository;

import java.util.List;

import com.hibernate_prova.dto.PersonaDto;
import com.hibernate_prova.entity.Persona;

public interface PersonaRepository {
    
    List<Persona> getPersonaList();

    Persona insertPersona(PersonaDto persona);

    Persona updatePersona(PersonaDto persona);

    Persona deletePersona(PersonaDto persona);

    List<Persona> findPersonaByName(String nome);

}
