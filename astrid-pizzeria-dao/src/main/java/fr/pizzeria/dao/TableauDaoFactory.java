package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.PizzaDaoTableau;

/**
 * Classe fille de DaoFactory
 * 
 * @author Astrid Hlavacek
 *
 */
public class TableauDaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoTableau
	 * 
	 * @see PizzaDaoTableau
	 */
	public TableauDaoFactory() {
		super(new PizzaDaoTableau());
	}
}
