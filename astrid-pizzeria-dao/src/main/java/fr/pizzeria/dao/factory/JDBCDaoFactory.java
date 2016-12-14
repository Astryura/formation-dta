package fr.pizzeria.dao.factory;

import java.sql.SQLException;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.other.JPADao;
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
		super(new PizzaDaoJDBC(), new CommandeDaoJPA(new JPADao()), new LivreurDaoJPA(new JPADao()),
				new ClientDaoJPA(new JPADao()));
	}

}
