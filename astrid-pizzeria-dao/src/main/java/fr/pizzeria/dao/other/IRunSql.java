package fr.pizzeria.dao.other;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Interface fonctionnelle permettant d'instancier la connexion JDBC et le
 * statement avec des types génériques
 *
 * @param <T>
 */
@FunctionalInterface
public interface IRunSql<T> {
	/**
	 * 
	 * @param conn
	 * @param st
	 * @return T
	 * @throws SQLException
	 */
	T exec(Connection conn, Statement st) throws SQLException;
}
