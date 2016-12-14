package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoFichier;
import fr.pizzeria.dao.commande.CommandeDaoFichier;
import fr.pizzeria.dao.livreur.LivreurDaoFichier;
import fr.pizzeria.dao.other.FichierDao;
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
		super(new PizzaDaoFichier(), new CommandeDaoFichier(new FichierDao()), new LivreurDaoFichier(new FichierDao()),
				new ClientDaoFichier(new FichierDao()));
	}

}
