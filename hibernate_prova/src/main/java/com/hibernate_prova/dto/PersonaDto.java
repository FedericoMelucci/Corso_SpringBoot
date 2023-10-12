package com.hibernate_prova.dto;

import java.util.HashSet;
import java.util.Set;

import com.hibernate_prova.entity.Corso;
import com.hibernate_prova.entity.Persona;
import com.hibernate_prova.entity.Tessera;
import com.hibernate_prova.entity.Trainer;

public class PersonaDto {

    Long id;
    String nome;
    String cognome;
    Integer età;

    Tessera tesseraIscrizione;

    Trainer trainer;

    Set<Corso> listaCorsi;

    
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Set<Corso> getListaCorsi() {
        return listaCorsi;
    }

    public void setListaCorsi(Set<Corso> listaCorsi) {
        this.listaCorsi = listaCorsi;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Tessera getTesseraIscrizione() {
        return tesseraIscrizione;
    }

    public void setTesseraIscrizione(Tessera tesseraIscrizione) {
        this.tesseraIscrizione = tesseraIscrizione;
    }

    public PersonaDto() {
        
    }

    public PersonaDto(Persona entity){
        this.nome=entity.getNome();
        this.cognome=entity.getCognome();
        this.età=entity.getEtà();
        this.tesseraIscrizione=new Tessera();
        tesseraIscrizione.setAttività(entity.getTesseraIscrizione().getAttività());
        tesseraIscrizione.setPromozione(entity.getTesseraIscrizione().getPromozione());
        this.trainer=new Trainer();
        trainer.setCognome(entity.getTrainer().getCognome());
        trainer.setNome(entity.getTrainer().getNome());
        trainer.setId(entity.getTrainer().getId());
        this.listaCorsi=new HashSet<>();
        this.listaCorsi=entity.getListaCorsi();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEtà() {
        return età;
    }

    public void setEtà(Integer età) {
        this.età = età;
    }
}
