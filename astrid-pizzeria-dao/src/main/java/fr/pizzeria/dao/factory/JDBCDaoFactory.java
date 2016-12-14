package fr.pizzeria.dao.factory;

import java.sql.SQLException;

import fr.pizzeria.dao.client.ClientDaoJDBC;
import fr.pizzeria.dao.commande.CommandeDaoJDBC;
import fr.pizzeria.dao.livreur.LivreurDaoJDBC;
import fr.pizzeria.dao.other.JDBCDao;
import fr.pizzeria.dao.pizza.PizzaDaoJDBC;

/**
 * Classe fille de DaoFactory
 * 
 * @author Astrid Hlavacek
 *
 */
public class JDBCDaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoJDBC
	 * 
	 * @see PizzaDaoJDBC
	 */
	public JDBCDaoFactory() throws SQLException {
		super(new PizzaDaoJDBC(), new CommandeDaoJDBC(new JDBCDao()), new LivreurDaoJDBC(new JDBCDao()),
				new ClientDaoJDBC(new JDBCDao()));
	}

}
