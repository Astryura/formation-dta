package fr.pizzeria.ihm;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class AddPizza implements Action {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public AddPizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		System.out.println("Cr�ez votre Pizza. \nNom de la Pizza");
		String nom = ihmUtil.getScanner().next();
		System.out.println("Prix de la Pizza");
		String prix = ihmUtil.getScanner().next();
		System.out.println("Cat�gorie de la Pizza : VIANDE, POISSON, SANS_VIANDE");
		String cat = ihmUtil.getScanner().next();
		CategoriePizza catP = CategoriePizza.valueOf(cat.toUpperCase());
		if (catP != null) {
			Pizza pizza = new Pizza("", nom, Double.parseDouble(prix), catP);
			ihmUtil.getPizzaDao().saveNewPizza(pizza);
		} else {
			System.out.println("Rentrez une cat�gorie valide");
		}

	}

	@Override
	public void describeAction() {
		System.out.println("2. Ajouter une nouvelle pizza");
	}

}
