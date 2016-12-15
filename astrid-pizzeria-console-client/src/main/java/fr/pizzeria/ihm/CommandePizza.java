package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class CommandePizza implements Action {

	private IhmUtilClient ihmUtil;
	private Client client;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public CommandePizza(IhmUtilClient ihmUtil, Client client) {
		super();
		this.ihmUtil = ihmUtil;
		this.client = client;
	}

	@Override
	public void doAction() {
		System.out.println("Liste des Pizzas :");
		PizzaDaoJPA piz = new PizzaDaoJPA(new JPADao());
		List<Pizza> list = piz.findAllPizzas();
		piz.close();
		list.forEach(p -> {
			System.out
					.println(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCatP());
		});
		System.out.println("Quel est le code de la Pizza que vous voulez commander ?");
		String codePizza = ihmUtil.getScanner().next();
		ihmUtil.getCommandeDao().newCommande(client.getId(), codePizza);

	}

	@Override
	public void describeAction() {
		System.out.println("1. Commander une Pizza");
	}

}
