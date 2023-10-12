package com.example.testscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RequestMapping("/") /* E' un'annotazione della dependence Springweb */
public class TestScopeApplication {

	@Autowired
	Persona p;

	@Autowired
	Persona b;

	@Autowired
	Persona c;


	public static void main(String[] args) {
		SpringApplication.run(TestScopeApplication.class, args);
	}


	@RequestMapping("/persona")
	public void stampaPersona() {
		System.out.println(Persona.contatore);
	}

	@RequestMapping("/persona/{a}") /* con {variabile} si indica la variabile del pathvariable */
	public void stampa(@PathVariable int a) {  /* annotazione PathVariable viene utilizzata per gestire le variabili del modello nella mappatura dell'URI della richiesta */
		if(a==1) {
			System.out.println("a è uguale a 1");
		} else {
		System.out.println("a è diverso da 1");
		}
	}

	/* La differenza è che con pathvariable inserivamo la variabile cosi com'era mentre con requestparam  */

		@RequestMapping("/persona1") /* per utilizzare il RequestParam si dovrà utilizzare la sintassi nel url con persona1?VALORE ma con required = false non sarà obbligatorio inserire il valore della variabile */
		public void stampaa(@RequestParam (required = false) int a) {  /* Può essere utilizzato per estrarre parametri di query, parametri di modulo e file dalla richiesta */
			if(a==1) {
				System.out.println("a è uguale a 1");
			} else {
			System.out.println("a è diverso da 1");
			}
	}
}
