package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Menu Principal</h1>
 * 
 * @author Astrid Hlavacek
 *
 */
public class MainMenuClient {

	Map<Integer, Action> actions = new HashMap<>();
	private IhmUtilClient ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public MainMenuClient(IhmUtilClient ihmUtil) {
		this.ihmUtil = ihmUtil;
		actions.put(0, new Subscribe(ihmUtil));
		actions.put(1, new Connexion(ihmUtil));
		actions.put(7, new ExitMenu(ihmUtil));
	}

	/**
	 * Affiche le menu
	 * 
	 * @throws NumberFormatException
	 */
	public void displayMenu() throws NumberFormatException {
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
			if (Integer.parseInt(input) == 1) {
				displayMenu();
			}
		} else if (Integer.parseInt(input) == 99) {
			actions.get(7).doAction();
		}
	}
}
