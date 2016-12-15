package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoTableau;
import fr.pizzeria.dao.commande.CommandeDaoTableau;
import fr.pizzeria.dao.livreur.LivreurDaoTableau;
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
		super(new PizzaDaoFichier(), new CommandeDaoTableau(), new LivreurDaoTableau(), new ClientDaoTableau());
	}

}
