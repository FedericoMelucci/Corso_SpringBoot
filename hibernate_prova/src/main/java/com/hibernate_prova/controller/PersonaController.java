package com.hibernate_prova.controller;

import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate_prova.dto.PersonaDto;
import com.hibernate_prova.entity.Persona;
import com.hibernate_prova.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired 
    PersonaService personaService;

    @Autowired
    private Environment environment;


    /**
     * @return
     */
    @GetMapping
    public ResponseEntity<List<PersonaDto>> getPersonaList() {
  
        /* System.out.println(environment.getProperties("titolo")); */
        List<PersonaDto> listaPersone=personaService.getPersonaList();
        return new ResponseEntity<List<PersonaDto>>(listaPersone,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonaDto> insertPersona(@RequestBody PersonaDto persona) {
        PersonaDto personaResult=personaService.insertPersona(persona);
        System.out.println("duori ins");
        return new ResponseEntity<PersonaDto>(personaResult, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PersonaDto> updatePersona(@RequestBody PersonaDto persona) {
        PersonaDto personaResult=personaService.updatePersona(persona);

        return new ResponseEntity<PersonaDto>(personaResult, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<PersonaDto> deletePersona(@RequestBody PersonaDto persona) {
        PersonaDto personaResult=personaService.deletePersona(persona);

        return new ResponseEntity<PersonaDto>(personaResult, HttpStatus.OK);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<PersonaDto>> getPersonaByName(@PathVariable String nome) {

        List<PersonaDto> listaPersone= personaService.findPersonaByName(nome);

        return new ResponseEntity<List<PersonaDto>>(listaPersone,HttpStatus.OK);
    } 
}
