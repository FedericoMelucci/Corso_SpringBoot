package com.hibernate_prova.service;

import java.util.List;

import com.hibernate_prova.dto.PersonaDto;
import com.hibernate_prova.entity.Persona;

public interface PersonaService {
    
    PersonaDto insertPersona(PersonaDto persona);

    List<PersonaDto> getPersonaList();

    PersonaDto updatePersona(PersonaDto persona);

    PersonaDto deletePersona(PersonaDto persona);

    List<PersonaDto> findPersonaByName(String nome);
}
