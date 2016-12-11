package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.pizza.PizzaDao;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class IhmUtil {

	/**
	 * scanner
	 * 
	 * @see IhmUtil#scanner
	 * @see IhmUtil#getScanner
	 * @see IhmUtil#setScanner
	 */
	private Scanner scanner;
	/**
	 * DaoFactory
	 * 
	 * @see IhmUtil#daoFactory
	 * @see IhmUtil#getPizzaDao
	 * @see IhmUtil#setPizzaDao
	 */
	private DaoFactory daoFactory;
	/**
	 * choixFactory
	 * 
	 * @see IhmUtil#choixFactory
	 * @see IhmUtil#getChoixFactory
	 * @see IhmUtil#setChoixFactory
	 */
	private String choixFactory;

	/**
	 * Constructeur enregistreur le scanner, le DaoFactory et la variable
	 * resource contenant le nom du DaoFactory
	 * 
	 * @param scanner
	 * @param daoFactory
	 * @param choixFactory
	 */
	public IhmUtil(Scanner scanner, DaoFactory daoFactory, String choixFactory) {

		this.scanner = scanner;
		this.daoFactory = daoFactory;
		this.choixFactory = choixFactory;
	}

	public String getChoixFactory() {
		return choixFactory;
	}

	public void setChoixFactory(String choixFactory) {
		this.choixFactory = choixFactory;
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

}
