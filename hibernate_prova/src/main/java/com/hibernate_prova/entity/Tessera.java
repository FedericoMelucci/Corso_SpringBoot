package com.hibernate_prova.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tessera implements Serializable{ /*  per far si che le relazione avvengano con successo le tabelle dovranno essere serializzate con questa sintassi */
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String attività;
    String promozione;



    public Tessera() {
        
    }





    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getAttività() {
        return attività;
    }


    public void setAttività(String attività) {
        this.attività = attività;
    }


    public String getPromozione() {
        return promozione;
    }


    public void setPromozione(String promozione) {
        this.promozione = promozione;
    }


}
