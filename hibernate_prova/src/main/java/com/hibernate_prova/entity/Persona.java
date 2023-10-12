package com.hibernate_prova.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hibernate_prova.dto.PersonaDto;

@Entity /* con questo comando e con @ID ci si riesce a Mappare un'entità in una tabella del database, per utilizzare queste annotazioni servirà obbligatoriamente inportare due dipendenze nel file pom.xml, vale a dire HIBERNATE e MYSQL DRIVER */
@Table(name= "Iscritti") /* questa annotazione serve per poter dare un nome ad una tabella  */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")/* in questo modo non si creerà un loop nella get  */
public class Persona implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) /* Questo è un metodo attraverso il quale si potrà incrementare in modo automatico l'ID */
    @Column(name= "id_persona")
    Long id;
    @Column(length= 5) /* con questa annotazione si intende che la lunghezza massima del nome deve essere di 5 caratteri */
    String nome;
    String cognome;
    @Transient/* è un'annotazione che serve per poter nascondere un campo dalla nostra tabella */
    Integer età;

    @CreationTimestamp
    Timestamp dataInserimento;


    Tessera tesseraIscrizione;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) /* con cascade si intende che la modifica di una tabella deve essere effettuata anche ai figli della tabella stessa */
    /* il fetchtype ci indica il caricamento in base al tipo di relazione: 
     * OneToOne avrà il valore EAGER
     * ManyToOne avrà il valore EAGER
     * OneToMany avrà il valore LAZY
     * ManyToMany avrà il valore LAZY 
     */
    @JoinColumn(name= "id_trainer")
    Trainer trainer;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( /* così facendo vincolerò hibernate a creare una tabella secondo alcuni limiti */
        name="persona_corsi",
        joinColumns = @JoinColumn(name= "id_persona"),
        inverseJoinColumns = @JoinColumn(name="id_corso")
    )
    Set<Corso> listaCorsi;



     public Trainer getTrainer() {
        return trainer;
    }


    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }


    public Tessera getTesseraIscrizione() {
        return tesseraIscrizione;
    }


    @OneToOne
    @JoinColumn()
    public void setTesseraIscrizione(Tessera tesseraIscrizione) {
        this.tesseraIscrizione = tesseraIscrizione;
    }

    public Persona() {
        
    }


     public Persona(PersonaDto dto) {
        this.id=dto.getId();
        this.nome=dto.getNome();
        this.cognome=dto.getCognome();
        this.età=dto.getEtà();
        this.tesseraIscrizione=new Tessera();
        tesseraIscrizione.setAttività(dto.getTesseraIscrizione().getAttività());
        tesseraIscrizione.setPromozione(dto.getTesseraIscrizione().getPromozione());
        this.trainer= new Trainer();
        trainer.setCognome(dto.getTrainer().getCognome());
        trainer.setNome(dto.getTrainer().getNome());
        trainer.setId(dto.getTrainer().getId());
        this.listaCorsi=new HashSet<>();
        this.listaCorsi=dto.getListaCorsi();
    }



    public Timestamp getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(Timestamp dataInserimento) {
        this.dataInserimento = dataInserimento;
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


    public Set<Corso> getListaCorsi() {
        return listaCorsi;
    }


    public void setListaCorsi(Set<Corso> listaCorsi) {
        this.listaCorsi = listaCorsi;
    }


    @Override
    public String toString() {
        return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", età=" + età + ", dataInserimento="
                + dataInserimento + ", tesseraIscrizione=" + tesseraIscrizione + ", trainer=" + trainer
                + ", listaCorsi=" + listaCorsi + "]";
    }
}
