package fr.pizzeria.dao.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.service.pizza.PizzaDaoJDBC;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class JDBCDao {
	/**
	 * instanciation de l'interface fonctionnelle
	 * 
	 * @param run
	 * @return T
	 */
	public <T> T execute(IRunSql<T> run) {
		String url = "jdbc:mysql://localhost:3306/pizzeriabd";
		try (Connection connection = DriverManager.getConnection(url, "root", "");
				Statement statement = connection.createStatement();) {

			return run.exec(connection, statement);
		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoJDBC.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}

	}
}
