package com.hibernate_prova.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Corso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id_corso")
    Long id;
    String nome;
    Integer numeroIscritti;


    @ManyToMany()
    @JoinTable( /* in questo modo io darò un nome alla tabella di join e darò un nome anche alle colonne della tabella stessa.  */
        name= "persona_corsi",
        joinColumns = @JoinColumn(name = "id_corso"),
        inverseJoinColumns=@JoinColumn(name = "id_persona")
    )
    Set<Persona> listaPersone;

    
    public Corso() {
        
    }


    
    public Set<Persona> getListaPersone() {
        return listaPersone;
    }


    public void setListaPersone(Set<Persona> listaPersone) {
        this.listaPersone = listaPersone;
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



    public Integer getNumeroIscritti() {
        return numeroIscritti;
    }



    public void setNumeroIscritti(Integer numeroIscritti) {
        this.numeroIscritti = numeroIscritti;
    }



    
}
