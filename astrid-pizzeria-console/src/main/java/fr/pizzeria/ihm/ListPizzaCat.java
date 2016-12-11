package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ListPizzaCat implements Action {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ListPizzaCat(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		List<Pizza> list = this.ihmUtil.getPizzaDao().findAllPizzasCat();
		list.forEach(p -> {
			System.out
					.println(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCatP());
		});
	}

	@Override
	public void describeAction() {
		System.out.println("5. Lister les pizzas par Catégories");
	}

}
