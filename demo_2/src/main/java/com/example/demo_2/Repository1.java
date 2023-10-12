package com.example.demo_2;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo_2.entity.Persona;

@Repository
public class Repository1 {

    /*
     * Quando ci troviamo all'interno della repository ci troviamo nella DATA ACCESS
     * LAYER, al cui interno viene utilizzato hibernate per fare delle richieste al
     * database.
     * MOKKARE la chiamata al database vuol dire farne una finta
     */
    public java.util.List<Persona> getPersonaRepository() { /* Questo metodo ci restituirà una istanza contenente una persona con nome e cognome sotto indicati */

        ArrayList<Persona> listaPersone=new ArrayList<Persona>(); /* così inizializziamo un array */
        Persona persona = new Persona(); /* Ho creato una nuova istanza */
        persona.setNome("Fabio");
        persona.setCognome("Urano");
        listaPersone.add(persona); /* in questo aggiungere l'istanza persona nell'array */

        return listaPersone;
    }


    public Persona inserisciPersonaRep(Persona persona) {

        return persona;
    }


    public Persona modificaPersonaRep(Persona persona) {

        return persona;
    }


     public Persona rimuoviPersonaRep(Persona persona) {

        return persona;
    }

}
