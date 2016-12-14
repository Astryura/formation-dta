package fr.pizzeria.dao;

import fr.pizzeria.dao.client.ClientDao;
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
	private ClientDao clientDao;

	/**
	 * Constructeur instancie le PizzaDao
	 * 
	 * @param pizzaDao
	 */
	public DaoFactory(PizzaDao pizzaDao, CommandeDao commandeDao, LivreurDao livreurDao, ClientDao clientDao) {
		super();
		this.pizzaDao = pizzaDao;
		this.commandeDao = commandeDao;
		this.livreurDao = livreurDao;
		this.clientDao = clientDao;
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

	public ClientDao getClientDao() {
		return clientDao;
	}
}
