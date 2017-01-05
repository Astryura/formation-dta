package fr.pizzeria.admin.metier;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJDBC;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;

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
