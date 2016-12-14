package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Menu Principal</h1>
 * 
 * @author Astrid Hlavacek
 *
 */
public class MainMenu {

	Map<Integer, Action> actions = new HashMap<Integer, Action>();
	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public MainMenu(IhmUtil ihmUtil) {
		actions.put(0, new ListPizza(ihmUtil));
		actions.put(1, new AddPizza(ihmUtil));
		actions.put(2, new UpdatePizza(ihmUtil));
		actions.put(3, new DeletePizza(ihmUtil));
		actions.put(4, new ListPizzaCat(ihmUtil));
		actions.put(5, new ListPizzaPrix(ihmUtil));
		if (ihmUtil.getChoixFactory().equals("fr.pizzeria.dao.JDBCDaoFactory")) {
			actions.put(6, new ImportePizza(ihmUtil));
			actions.put(7, new ListCommande(ihmUtil, 8));
			actions.put(8, new AddLivreur(ihmUtil, 9));
			actions.put(9, new ImportePizza(ihmUtil));
		} else {
			actions.put(6, new ListCommande(ihmUtil, 7));
			actions.put(7, new AddLivreur(ihmUtil, 8));
			actions.put(8, new ImportePizza(ihmUtil));
		}
		actions.put(10, new ExitMenu(ihmUtil));
		this.ihmUtil = ihmUtil;
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

		if (Integer.parseInt(input) <= 10) {
			actions.get((Integer.parseInt(input)) - 1).doAction();
			displayMenu();
		} else if (Integer.parseInt(input) == 99) {
			actions.get(10).doAction();
		}
	}
}
