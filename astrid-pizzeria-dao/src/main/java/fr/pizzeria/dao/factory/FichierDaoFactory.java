package fr.pizzeria.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoTableau;
import fr.pizzeria.dao.commande.CommandeDaoTableau;
import fr.pizzeria.dao.livreur.LivreurDaoTableau;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoFichier;

/**
 * Classe fille de DaoFactory
 * 
 * @author Astrid Hlavacek
 *
 */
@Component
@Qualifier("FichierFactory")
public class FichierDaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoFichier
	 * 
	 * @see PizzaDaoFichier
	 */
	@Autowired
	public FichierDaoFactory(@Qualifier("Fichier") PizzaDao pizzadao) {
		super(pizzadao, new CommandeDaoTableau(), new LivreurDaoTableau(), new ClientDaoTableau());
	}

}
