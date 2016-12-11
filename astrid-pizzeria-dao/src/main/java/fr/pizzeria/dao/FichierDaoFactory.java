package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.PizzaDaoFichier;

/**
 * Classe fille de DaoFactory
 * 
 * @author Astrid Hlavacek
 *
 */
public class FichierDaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoFichier
	 * 
	 * @see PizzaDaoFichier
	 */
	public FichierDaoFactory() {
		super(new PizzaDaoFichier());
	}

}
