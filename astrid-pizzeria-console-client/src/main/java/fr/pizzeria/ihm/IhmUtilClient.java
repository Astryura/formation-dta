package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.client.ClientDao;
import fr.pizzeria.dao.commande.CommandeDao;
import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.dao.livreur.LivreurDao;
import fr.pizzeria.dao.pizza.PizzaDao;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class IhmUtilClient {

	/**
	 * scanner
	 * 
	 * @see IhmUtilClient#scanner
	 * @see IhmUtilClient#getScanner
	 * @see IhmUtilClient#setScanner
	 */
	private Scanner scanner;
	/**
	 * DaoFactory
	 * 
	 * @see IhmUtilClient#daoFactory
	 * @see IhmUtilClient#getPizzaDao
	 * @see IhmUtilClient#setPizzaDao
	 */
	private DaoFactory daoFactory;

	/**
	 * Constructeur enregistreur le scanner, le DaoFactory et la variable
	 * resource contenant le nom du DaoFactory
	 * 
	 * @param scanner
	 * @param daoFactory
	 * @param choixFactory
	 */
	public IhmUtilClient(Scanner scanner, DaoFactory daoFactory) {

		this.scanner = scanner;
		this.daoFactory = daoFactory;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public PizzaDao getPizzaDao() {
		return daoFactory.getPizzaDao();
	}

	public void setPizzaDao(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public CommandeDao getCommandeDao() {
		return daoFactory.getCommandeDao();
	}

	public LivreurDao getLivreurDao() {
		return daoFactory.getLivreurDao();
	}

	public ClientDao getClientDao() {
		return daoFactory.getClientDao();
	}

}
