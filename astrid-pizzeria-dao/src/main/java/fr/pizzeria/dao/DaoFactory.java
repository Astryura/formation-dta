package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.PizzaDao;

/**
 * <h1>DaoFactory</h1> <b>Classe Abstraite sur le model du design pattern
 * AbstractFactory, pour gérer le DAO</b>
 * 
 * @author Astrid Hlavacek
 *
 */
public abstract class DaoFactory {

	/**
	 * Le PizzaDao
	 * 
	 * @see PizzaDao
	 */
	private PizzaDao pizzaDao;

	/**
	 * Constructeur instancie le PizzaDao
	 * 
	 * @param pizzaDao
	 */
	public DaoFactory(PizzaDao pizzaDao) {
		super();
		this.pizzaDao = pizzaDao;
	}

	/**
	 * getPizzaDao(), retourne le PizzaDao
	 * 
	 * @return pizzaDao
	 */
	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}
}
