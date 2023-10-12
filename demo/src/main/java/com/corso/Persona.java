package com.corso;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// @Component Questo metodo è stato superato 
public class Persona {
    String nome;
    String cognome;
    Indirizzo indirizzo;

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


    public Indirizzo getIndirizzo() {
        return indirizzo;
    }


    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }


    public Indirizzo getI() {
        return i;
    }


    public void setI(Indirizzo i) {
        this.i = i;
    }


    @Autowired
    Indirizzo i;

    
    public Persona(){

    }

    
}
