package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.commande.CommandeDao;

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
	private CommandeDao commandeDao;

	/**
	 * Constructeur enregistreur le scanner, le DaoFactory et la variable
	 * resource contenant le nom du DaoFactory
	 * 
	 * @param scanner
	 * @param daoFactory
	 * @param choixFactory
	 */
	public IhmUtilClient(Scanner scanner, CommandeDao commandeDao) {

		this.scanner = scanner;
		this.commandeDao = commandeDao;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public CommandeDao getCommandeDao() {
		return commandeDao;
	}

	public void setCommandeDao(CommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}

}
