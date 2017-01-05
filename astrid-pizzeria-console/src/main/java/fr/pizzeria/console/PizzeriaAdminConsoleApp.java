package fr.pizzeria.console;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaAppSpringConfig.class)) {
			// try (ClassPathXmlApplicationContext context = new
			// ClassPathXmlApplicationContext("application-config.xml")) {
			Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
			Logger.getLogger("org.springframework").setLevel(Level.SEVERE);
			MainMenu mainMenu = context.getBean(MainMenu.class);
			mainMenu.displayMenu();
		}

	}
}