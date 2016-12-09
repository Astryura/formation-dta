package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.pizza.PizzaDao;

public class IhmUtil {

	private Scanner scanner;
	private DaoFactory daoFactory;
	private String choixFactory;

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
