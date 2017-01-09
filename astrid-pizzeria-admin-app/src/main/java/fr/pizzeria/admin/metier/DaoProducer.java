package fr.pizzeria.admin.metier;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import fr.pizzeria.dao.service.pizza.PizzaDao;
import fr.pizzeria.dao.service.pizza.PizzaDaoJDBC;
import fr.pizzeria.dao.service.pizza.PizzaDaoJPA;

public class DaoProducer {

	@Produces
	@Named("pizzaDaoJDBC")
	public PizzaDao getPizzaDaoJDBC() {
		return new PizzaDaoJDBC();
	}

	@Produces
	@Named("pizzaDaoJPA")
	public PizzaDao getPizzaDaoJPA() {
		return new PizzaDaoJPA();
	}

}
