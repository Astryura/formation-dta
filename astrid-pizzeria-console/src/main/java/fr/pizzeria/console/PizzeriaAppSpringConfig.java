package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.dao.factory.JPADaoFactory;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {
	@Bean
	public DaoFactory getDao() {
		return new JPADaoFactory();
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

}
