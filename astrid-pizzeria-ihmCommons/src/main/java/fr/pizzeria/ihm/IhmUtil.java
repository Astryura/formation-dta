package fr.pizzeria.ihm;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
@Component
public class IhmUtil {

	/**
	 * scanner
	 * 
	 * @see IhmUtil#scanner
	 * @see IhmUtil#getScanner
	 * @see IhmUtil#setScanner
	 */
	@Autowired
	private Scanner scanner;
	/**
	 * DaoFactory
	 * 
	 * @see IhmUtil#daoFactory
	 * @see IhmUtil#getPizzaDao
	 * @see IhmUtil#setPizzaDao
	 */
	@Autowired
	@Qualifier("JPARepoFactory")
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

	public IhmUtil(Scanner scanner, DaoFactory daoFactory) {
		this.scanner = scanner;
		this.daoFactory = daoFactory;
	}

	@PostConstruct
	public void init() {
		this.choixFactory = daoFactory.getClass().getName();
	}

	public IhmUtil() {
		super();

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
