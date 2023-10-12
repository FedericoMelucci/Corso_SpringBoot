package com.hibernate_prova.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate_prova.dto.PersonaDto;
import com.hibernate_prova.entity.Persona;
import com.hibernate_prova.repository.PersonaRepository;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;



    @Override
    public List<PersonaDto> getPersonaList() {

        List<Persona> listaEntity= personaRepository.getPersonaList();
        
        List<PersonaDto> listDto= listaEntity.stream().map(entity -> new PersonaDto(entity)).collect(Collectors.toList());
        return listDto;
    }



    @Override
    public PersonaDto insertPersona(PersonaDto persona) {
        Persona entity= personaRepository.insertPersona(persona);
        
        PersonaDto dto= new PersonaDto(entity);
        System.out.println("duori ins");
        return dto;
    }



    @Override
    public PersonaDto updatePersona(PersonaDto persona) {
        
        Persona entity= personaRepository.updatePersona(persona);

        PersonaDto dto= new PersonaDto(entity);
        return dto;
    }
 



    @Override
    public PersonaDto deletePersona(PersonaDto persona) {
        
        Persona entity= personaRepository.deletePersona(persona);

        PersonaDto dto= new PersonaDto(entity);
        return dto;
    }



    @Override
    public List<PersonaDto> findPersonaByName(String nome) {

        List<Persona> listaEntity= personaRepository.findPersonaByName(nome);

        List<PersonaDto> listDto= listaEntity.stream().map(entity -> new PersonaDto(entity)).collect(Collectors.toList());
        return listDto; 
    }
    
}
