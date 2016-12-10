package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;

/**
 * 
 * @author Hlavacek Astrid
 *
 */

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NumberFormatException {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String choix = bundle.getString("dao.impl");
		DaoFactory daoFactory = (DaoFactory) Class.forName(choix).newInstance();

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory, choix);

		MainMenu mainMenu = new MainMenu(ihmUtil);

		mainMenu.displayMenu();

	}
}