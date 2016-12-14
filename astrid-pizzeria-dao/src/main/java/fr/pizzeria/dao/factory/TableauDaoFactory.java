package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoTableau;
import fr.pizzeria.dao.commande.CommandeDaoTableau;
import fr.pizzeria.dao.livreur.LivreurDaoTableau;
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
		super(new PizzaDaoTableau(), new CommandeDaoTableau(), new LivreurDaoTableau(), new ClientDaoTableau());
	}
}
