package fr.pizzeria.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoJDBC;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJDBC;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJDBC;

/**
 * Classe fille de DaoFactory
 * 
 * @author Astrid Hlavacek
 *
 */
@Component
@Qualifier("JDBCFactory")
public class JDBCDaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoJDBC
	 * 
	 * @see PizzaDaoJDBC
	 */
	@Autowired
	public JDBCDaoFactory(@Qualifier("JDBC") PizzaDao pizzadao) {
		super(pizzadao, new CommandeDaoJPA(), new LivreurDaoJDBC(), new ClientDaoJDBC());
	}

}
