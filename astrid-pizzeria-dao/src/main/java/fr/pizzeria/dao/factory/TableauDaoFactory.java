package fr.pizzeria.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoTableau;
import fr.pizzeria.dao.commande.CommandeDaoTableau;
import fr.pizzeria.dao.livreur.LivreurDaoTableau;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoTableau;

/**
 * Classe fille de DaoFactory
 * 
 * @author Astrid Hlavacek
 *
 */
@Component
@Qualifier("TableauFactory")
public class TableauDaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoTableau
	 * 
	 * @see PizzaDaoTableau
	 */
	@Autowired
	public TableauDaoFactory(@Qualifier("Tableau") PizzaDao pizzadao) {
		super(pizzadao, new CommandeDaoTableau(), new LivreurDaoTableau(), new ClientDaoTableau());
	}
}
