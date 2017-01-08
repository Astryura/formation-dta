package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>Menu Principal</h1>
 * 
 * @author Astrid Hlavacek
 *
 */
@Component
public class MainMenu {

	Map<Integer, Action> actions = new HashMap<>();
	@Autowired
	private IhmUtil ihmUtil;
	@Autowired
	ListPizza list;

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
		if ("fr.pizzeria.dao.factory.JDBCDaoFactory".equals(ihmUtil.getChoixFactory())
				|| "fr.pizzeria.dao.factory.JPADaoFactory".equals(ihmUtil.getChoixFactory())
				|| "fr.pizzeria.dao.factory.JpaSpringDaoFactory".equals(ihmUtil.getChoixFactory())
				|| "fr.pizzeria.dao.factory.JpaRepoDaoFactory".equals(ihmUtil.getChoixFactory())) {
			actions.put(6, new ImportePizza(ihmUtil));
			actions.put(7, new ListCommande(ihmUtil, 8));
			actions.put(8, new AddLivreur(ihmUtil, 9));
			actions.put(9, new ExpeditionCommande(ihmUtil, 10));
			actions.put(10, new ListLogPerformance(ihmUtil, 11));
		} else {
			actions.put(6, new ListCommande(ihmUtil, 7));
			actions.put(7, new AddLivreur(ihmUtil, 8));
			actions.put(8, new ExpeditionCommande(ihmUtil, 9));
			actions.put(9, new ListLogPerformance(ihmUtil, 10));
		}
		actions.put(11, new ExitMenu(ihmUtil));
		this.ihmUtil = ihmUtil;
	}

	@PostConstruct
	public void init() {
		actions.put(0, list);
		actions.put(1, new AddPizza(ihmUtil));
		actions.put(2, new UpdatePizza(ihmUtil));
		actions.put(3, new DeletePizza(ihmUtil));
		actions.put(4, new ListPizzaCat(ihmUtil));
		actions.put(5, new ListPizzaPrix(ihmUtil));
		if ("fr.pizzeria.dao.factory.JDBCDaoFactory".equals(ihmUtil.getChoixFactory())
				|| "fr.pizzeria.dao.factory.JPADaoFactory".equals(ihmUtil.getChoixFactory())
				|| "fr.pizzeria.dao.factory.JpaSpringDaoFactory".equals(ihmUtil.getChoixFactory())
				|| "fr.pizzeria.dao.factory.JpaRepoDaoFactory".equals(ihmUtil.getChoixFactory())) {
			actions.put(6, new ImportePizza(ihmUtil));
			actions.put(7, new ListCommande(ihmUtil, 8));
			actions.put(8, new AddLivreur(ihmUtil, 9));
			actions.put(9, new ExpeditionCommande(ihmUtil, 10));
			actions.put(10, new ListLogPerformance(ihmUtil, 11));
		} else {
			actions.put(6, new ListCommande(ihmUtil, 7));
			actions.put(7, new AddLivreur(ihmUtil, 8));
			actions.put(8, new ExpeditionCommande(ihmUtil, 9));
			actions.put(9, new ListLogPerformance(ihmUtil, 10));
		}
		actions.put(11, new ExitMenu(ihmUtil));
	}

	public MainMenu() {
		super();

	}

	/**
	 * Affiche le menu
	 * 
	 */
	public void displayMenu() {
		actions.forEach((k, v) -> actions.get(k).describeAction());
		parseAndExec();
	}

	/**
	 * Execute l'action choisie
	 * 
	 */
	private void parseAndExec() {
		String input = ihmUtil.getScanner().next();

		if (Integer.parseInt(input) <= 11) {
			actions.get((Integer.parseInt(input)) - 1).doAction();
			displayMenu();
		} else if (Integer.parseInt(input) == 99) {
			actions.get(11).doAction();
		}
	}
}
