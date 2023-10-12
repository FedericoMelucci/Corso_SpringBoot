package com.hibernate_prova.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id_trainer") /* questa annotazione è utile per dare un nome ad una colonna */
    Long id;
    String nome;
    String cognome;


    @OneToMany(mappedBy = "trainer")
    public Set<Persona> listAllievi;

    public Trainer() {

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

    public Set<Persona> getListAllievi() {
        return listAllievi;
    }

    public void setListAllievi(Set<Persona> listAllievi) {
        this.listAllievi = listAllievi;
    }

}
