package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "fr.pizzeria.ihm", "fr.pizzeria.dao" })
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

}
