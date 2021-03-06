package fr.pizzeria.ihm;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class UpdatePizza implements Action {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public UpdatePizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		System.out.println("Modifiez votre Pizza. \nCode de la Pizza que vous voulez modifier");
		String codePizza = ihmUtil.getScanner().next();
		System.out.println("Nouveau Code de la Pizza");
		String codeU = ihmUtil.getScanner().next();
		System.out.println("Nouveau Nom de la Pizza");
		String nomU = ihmUtil.getScanner().next();
		System.out.println("Nouveau Prix de la Pizza");
		String prixU = ihmUtil.getScanner().next();
		System.out.println("Nouvelle Catégorie de la Pizza : VIANDE, POISSON, SANS_VIANDE");
		String cat = ihmUtil.getScanner().next();
		CategoriePizza catP = CategoriePizza.valueOf(cat.toUpperCase());
		if (catP != null) {
			Pizza pizza = new Pizza(codeU, nomU, Double.parseDouble(prixU), catP);
			ihmUtil.getPizzaDao().updatePizza(codePizza, pizza);
		} else {
			System.out.println("Rentrez une catégorie valide");
		}

	}

	@Override
	public void describeAction() {
		System.out.println("3. Mettre à jour une pizza");
	}

}
