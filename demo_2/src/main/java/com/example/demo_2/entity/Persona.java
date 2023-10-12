package com.example.demo_2.entity; /*  questo è il percorso di un package, vale a dire una sotto cartella del file java */

import javax.validation.constraints.Size;

public class Persona {
    @Size(max = 4) /* in questo modo si impone il limite di caratteri al nome di massimo 4 caratteri */
    String nome;
    String cognome;

    public Persona() {
        
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

}
