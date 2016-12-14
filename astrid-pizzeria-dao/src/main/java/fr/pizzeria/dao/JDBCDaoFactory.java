package fr.pizzeria.dao;

import java.sql.SQLException;

import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
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
		super(new PizzaDaoJDBC(), new CommandeDaoJPA(), new LivreurDaoJPA());
	}

}
