package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.dao.factory.TableauDaoFactory;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfigTest {
	@Bean
	public DaoFactory getDao() {
		return new TableauDaoFactory();
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
