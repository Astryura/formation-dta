package fr.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.ihm.IhmUtilClient;
import fr.pizzeria.ihm.MainMenuClient;

/**
 * <h1>PizzeriaClientConsoleApp</h1><b>Classe de démarrage de l'application.</b>
 * 
 * @author Astrid Hlavacek
 * @version 1
 * @since 2016-12-12
 */

public class PizzeriaClientConsoleApp {

	/**
	 * Constructeur privé, permet de garantir que la classe ne pourra pas être
	 * instancié
	 */
	private PizzeriaClientConsoleApp() {
		throw new IllegalAccessError("Console class");
	}

	/**
	 * Méthode main, l'exécution du programme commence par cette fonction
	 * 
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		IhmUtilClient ihmUtil = new IhmUtilClient(new Scanner(System.in), new CommandeDaoJPA());

		MainMenuClient mainMenu = new MainMenuClient(ihmUtil);

		mainMenu.displayMenu();

	}
}