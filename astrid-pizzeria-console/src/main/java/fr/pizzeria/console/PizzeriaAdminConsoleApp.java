package fr.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	 * Constructeur privé, permet de garantir que la classe ne pourra pas être
	 * instancié
	 */
	private PizzeriaAdminConsoleApp() {
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

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml")) {
			MainMenu mainMenu = context.getBean(MainMenu.class);
			mainMenu.displayMenu();
		}

	}
}