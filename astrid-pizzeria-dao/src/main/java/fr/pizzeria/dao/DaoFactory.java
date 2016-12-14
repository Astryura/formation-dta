package fr.pizzeria.dao;

import fr.pizzeria.dao.commande.CommandeDao;
import fr.pizzeria.dao.livreur.LivreurDao;
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
	private CommandeDao commandeDao;
	private LivreurDao livreurDao;

	/**
	 * Constructeur instancie le PizzaDao
	 * 
	 * @param pizzaDao
	 */
	public DaoFactory(PizzaDao pizzaDao, CommandeDao commandeDao, LivreurDao livreurDao) {
		super();
		this.pizzaDao = pizzaDao;
		this.commandeDao = commandeDao;
		this.livreurDao = livreurDao;
	}

	/**
	 * getPizzaDao(), retourne le PizzaDao
	 * 
	 * @return pizzaDao
	 */
	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

	public CommandeDao getCommandeDao() {
		return commandeDao;
	}

	public LivreurDao getLivreurDao() {
		return livreurDao;
	}
}
