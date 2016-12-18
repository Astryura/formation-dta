package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.model.Client;

/**
 * <h1>Menu Principal</h1>
 * 
 * @author Astrid Hlavacek
 *
 */
public class MainMenuClient {

	Map<Integer, Action> actions = new HashMap<>();
	private IhmUtil ihmUtil;
	/**
	 * Client connecté
	 */
	private Client client;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 * @param client
	 */
	public MainMenuClient(IhmUtil ihmUtil, Client client) {
		this.ihmUtil = ihmUtil;
		this.client = client;
		if (client != null) {
			actions.put(0, new CommandePizza(ihmUtil, client));
			actions.put(1, new ListCommande(ihmUtil, client));
		} else {
			actions.put(0, new Subscribe(ihmUtil));
			actions.put(1, new Connexion(ihmUtil));
		}
		actions.put(7, new ExitMenu(ihmUtil));
	}

	/**
	 * Affiche le menu
	 * 
	 */
	public void displayMenu() {
		if (client != null) {
			System.out.println("Bonjour :" + client.getNom() + " " + client.getPrenom());
		}
		actions.forEach((k, v) -> actions.get(k).describeAction());
		parseAndExec();
	}

	/**
	 * Execute l'action choisie
	 * 
	 */
	private void parseAndExec() {
		String input = ihmUtil.getScanner().next();

		if (Integer.parseInt(input) <= 2) {
			actions.get((Integer.parseInt(input)) - 1).doAction();
			if (Integer.parseInt(input) == 1 && client == null) {
				displayMenu();
			} else if (client != null) {
				displayMenu();
			}
		} else if (Integer.parseInt(input) == 99) {
			actions.get(7).doAction();
		}
	}
}
