package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.other.JPADao;
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
		super(new PizzaDaoJPA(new JPADao()), new CommandeDaoJPA(new JPADao()), new LivreurDaoJPA(new JPADao()),
				new ClientDaoJPA(new JPADao()));
	}

}
