package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.PizzaDaoJPA;

public class JPADaoFactory extends DaoFactory {

	public JPADaoFactory() {
		super(new PizzaDaoJPA());
	}

}
