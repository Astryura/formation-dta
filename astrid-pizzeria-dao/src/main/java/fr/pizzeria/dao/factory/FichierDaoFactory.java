package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.other.JPADao;
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
		super(new PizzaDaoFichier(), new CommandeDaoJPA(new JPADao()), new LivreurDaoJPA(new JPADao()),
				new ClientDaoJPA(new JPADao()));
	}

}
