package com.example.demo_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.example.demo_2.entity.Persona;

@RestController /* per esporre i servizi rest */
                /* i verbi, cioè le azioni che verrano indicate e che verranno effettuate dal server sono: GET(recuperare i dati), POST(per inviare dei dati), PUT(per aggiornare dei dati), DELETE(per eliminare dei dati), permettono di comunicare con il server */
@RequestMapping("/")
public class Controller1 {

    @Autowired
    Service1 service;

    // @RequestMapping("/persona")
    // public Persona getPersona() {
    //     /*
    //      * da REPOSITORY si farà una chiamata al database(ORM-HIBERNATE), prendendo dei
    //      * dati, con il metodo che si trova all'interno di SERVICE richiameremo
    //      * REPOSITORY( BUSINESS LOGIC LAYER), il CONTROLLER a sua volta effettuerà una
    //      * chiamata al SERVICE
    //      * REPOSITORY -> ATTRAVERSO IL SERVICE -> DOMANDA AL DATABASE (ORM-HIBERNATE) -> TRAMITE UNA CHIAMATA CHE VERRA' EFFETTUATA DAL CONTROLLER
    //      */
    //     Persona p = service.getPersonaService(); /* In questo caso si richiama il metodo di service */
    //     System.out.println(p.getCognome());

    //     return p;
    // }



    @GetMapping("/persone")
    public List<Persona> getListPersone() {

        return service.getPersonaService();
    }

    // @PostMapping("/persone") /* in questo modo identifichiamo la rotta in cui ci troveremo */
    // public Persona inserisciPersona(@RequestBody @Valid Persona persona, BindingResult result) {/* RequestBody serve per poter far funzionare i servizi rest, per far prendere l'oggetto */
    // /* Valid serve per poter inserire dei limiti di validazione ad un input, come ad esempio adesso il nome non potrà essere più lungo di 4 caratteri(vedere Persona.java(Annotation @Size)) */

    //     if(result .hasErrors()) {
    //         System.out.println("C'è un errore");
    //     }

    //     return service.inserisciPersonaService(persona);
    // }

    @PostMapping("/persone")
    public ResponseEntity<Persona> inserisciPersona(@RequestBody Persona persona) {

        HttpHeaders header= new HttpHeaders(); /* in questo modo inizializziamo un header, che potrà essere aggiunto */
        header.set("prova", "valore"); /* in questo modo assegniamo un valore ad header */

        Persona personaRaccolta= service.inserisciPersonaService(persona);

        return new ResponseEntity<Persona>(personaRaccolta,header, HttpStatus.CREATED); /* con questo metodo(HTTPSTATUS.) possiamo modificare e personalizzare uno stato di una risposta */
    }

    @PutMapping("/persone") /* in questo modo identifichiamo la rotta in cui ci troveremo */
    public Persona modificaPersona(@RequestBody Persona persona) {/* RequestBody serve per poter far funzionare i servizi rest, per far prendere l'oggetto */

        return service.modificaPersonaService(persona);
    }

    @DeleteMapping("/persone") /* in questo modo identifichiamo la rotta in cui ci troveremo */
    public Persona rimuoviPersona(@RequestBody Persona persona) {/* RequestBody serve per poter far funzionare i servizi rest, per far prendere l'oggetto */

        return service.rimuoviPersonaService(persona);
    }
}
