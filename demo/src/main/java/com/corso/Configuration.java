package com.corso;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration /* In questo modo la identifichiamo come una classe configuration */
public class Configuration {

    @Bean /* E' un oggetto di cui viene creata un'istanza assemblato e gestito in altro modo da un contenitore IoC Spring */
    @Qualifier("1") /* Viene utilizzato per identificare uno specifico metodo e per creare una nuova istanza*/
    public Persona configura() {
        Persona persona= new Persona(); /* in questo modo creiamo una istanza */
        persona.setNome("Fabio");
        persona.setCognome("Verdi");
        return persona;
    }
        
    @Bean
    @Qualifier("2")
    public Persona configura2() {
        Persona persona= new Persona();
        persona.setNome("Biagio");
        persona.setCognome("Rossi");
        return persona;
    }
}
