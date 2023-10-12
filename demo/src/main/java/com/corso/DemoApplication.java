package com.corso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/")
@ComponentScan("com.corso.test") /* Serve per indicare a spring quali sono le cartelle da ispezionare */
public class DemoApplication {

	@Autowired
	@Qualifier("2") /* in questo modo si richiamerà uno specifico metodo */
	Persona persona;

	public static void main(String[] args) { /* void si intende un metodo che non restituisce nulla */
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@RequestMapping("/") /* requestmapping indica l'url, ossia il path, un percorso */
	public void stampaNome(){
		System.out.println(persona.getNome());
	}

}
