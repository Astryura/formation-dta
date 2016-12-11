package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;

/**
 * <h1>PizzeriaAdminConsoleApp</h1><b>Classe de démarrage de l'application.</b>
 * 
 * @author Astrid Hlavacek
 * @version 1
 * @since 2016-11-14
 */

public class PizzeriaAdminConsoleApp {

	/**
	 * Méthode main, l'exécution du programme commence par cette fonction
	 * 
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String choix = bundle.getString("dao.impl");
		DaoFactory daoFactory = (DaoFactory) Class.forName(choix).newInstance();

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory, choix);

		MainMenu mainMenu = new MainMenu(ihmUtil);

		mainMenu.displayMenu();

	}

	private PizzeriaAdminConsoleApp() {
		throw new IllegalAccessError("Console class");
	}
}