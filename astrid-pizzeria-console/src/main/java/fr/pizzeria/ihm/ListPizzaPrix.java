package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ListPizzaPrix implements Action {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ListPizzaPrix(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		Pizza p = this.ihmUtil.getPizzaDao().findPrixMaxPizza();
		System.out.println(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCatP());
	}

	@Override
	public void describeAction() {
		System.out.println("6. Afficher la Pizza la plus cher");
	}

}
