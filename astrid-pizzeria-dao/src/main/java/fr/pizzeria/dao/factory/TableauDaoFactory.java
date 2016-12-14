package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.other.JPADao;
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
		super(new PizzaDaoTableau(), new CommandeDaoJPA(new JPADao()), new LivreurDaoJPA(new JPADao()),
				new ClientDaoJPA(new JPADao()));
	}
}