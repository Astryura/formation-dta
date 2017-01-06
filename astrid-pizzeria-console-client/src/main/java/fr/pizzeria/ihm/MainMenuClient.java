package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Client;

/**
 * <h1>Menu Principal</h1>
 * 
 * @author Astrid Hlavacek
 *
 */
@Component
public class MainMenuClient {

	Map<Integer, Action> actions = new HashMap<>();
	@Autowired
	private IhmUtil ihmUtil;
	/**
	 * Client connecté
	 */
	private Client client = null;

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

	@PostConstruct
	public void init() {
		if (client != null) {
			actions.put(0, new CommandePizza(ihmUtil, client));
			actions.put(1, new ListCommande(ihmUtil, client));
		} else {
			actions.put(0, new Subscribe(ihmUtil));
			actions.put(1, new Connexion(ihmUtil));
		}
		actions.put(7, new ExitMenu(ihmUtil));
	}

	public MainMenuClient() {

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
