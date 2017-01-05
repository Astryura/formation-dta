package fr.pizzeria.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author AstridHlavacek
 *
 */
@Component
public class ListPizza implements Action {
	@Autowired
	@Qualifier("JdbcTemplateFactory")
	private DaoFactory daoFactory;
	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ListPizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	public ListPizza() {
		super();
	}

	@Override
	public void doAction() {
		List<Pizza> list = this.daoFactory.getPizzaDao().findAllPizzas();
		list.forEach(p -> {
			System.out
					.println(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCatP());
		});
		System.out.println(Pizza.getNbPizzas() + " Pizzas enregistrées");
	}

	@Override
	public void describeAction() {
		System.out.println("1. Lister les pizzas");
	}

	public String getDescribe() {
		return "1. Lister les pizzas";
	}

}
