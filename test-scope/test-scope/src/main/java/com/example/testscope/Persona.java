package com.example.testscope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") /*
                     * si intende la creazione delle istanze, di solito sono singleton, MA SI PUò
                     * METTERE PROTOTYPE SI CREA UN'ISTANZA OGNI VOLTA SI FARà AUTOWIRED
                     */
public class Persona {

    String nome;
    String cognome;
    static int contatore;

    public Persona() {
        contatore++; /*
                      * con singleton il contatore non aumenterà mai, quindi si crea una sola istanza
                      * ogni qualvolta che si usa un autowired
                      */
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
