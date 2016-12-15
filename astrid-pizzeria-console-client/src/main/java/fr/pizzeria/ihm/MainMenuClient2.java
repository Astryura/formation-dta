package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.model.Client;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class MainMenuClient2 {
	Map<Integer, Action> actions = new HashMap<>();
	private IhmUtilClient ihmUtil;
	private Client client;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public MainMenuClient2(IhmUtilClient ihmUtil, Client client) {
		this.ihmUtil = ihmUtil;
		this.client = client;
		actions.put(0, new CommandePizza(ihmUtil, client));
		actions.put(1, new ListCommande(ihmUtil, client));
		actions.put(7, new ExitMenu(ihmUtil));
	}

	/**
	 * Affiche le menu
	 * 
	 * @throws NumberFormatException
	 */
	public void displayMenu() throws NumberFormatException {
		System.out.println("Bonjour :" + client.getNom() + " " + client.getPrenom());
		actions.forEach((k, v) -> {
			actions.get(k).describeAction();
		});
		parseAndExec();
	}

	/**
	 * Execute l'action choisie
	 * 
	 * @throws NumberFormatException
	 */
	private void parseAndExec() throws NumberFormatException {
		String input = ihmUtil.getScanner().next();

		if (Integer.parseInt(input) <= 2) {
			actions.get((Integer.parseInt(input)) - 1).doAction();
			displayMenu();
		} else if (Integer.parseInt(input) == 99) {
			actions.get(7).doAction();
		}
	}
}
