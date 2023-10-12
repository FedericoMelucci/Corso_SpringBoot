package com.example.demo_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication /* Questa annotation contiene al suo interno tre altre annotation, CONFIGURATION(che serve per configurare i Bean, le classi), ENABLEAUTOCONFIGURATION(che serve per abilitare la configurazione automatica, potrà configurare anche le dipendenze JAR cercando di configurarle in automatico) e infine COMPONENTSCAN(effettua scansioni per i componenti Spring annotati, cioè ispezionare tutte le sotto cartelle)*/
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
