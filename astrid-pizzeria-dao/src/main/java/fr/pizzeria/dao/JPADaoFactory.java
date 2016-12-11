package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.PizzaDaoJPA;

/**
 * Classe fille de DaoFactory
 * 
 * @author Astrid Hlavacek
 *
 */
public class JPADaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoJPA
	 * 
	 * @see PizzaDaoJPA
	 */
	public JPADaoFactory() {
		super(new PizzaDaoJPA());
	}

}
