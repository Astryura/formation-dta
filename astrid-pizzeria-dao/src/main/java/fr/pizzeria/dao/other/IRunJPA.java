package fr.pizzeria.dao.other;

import java.sql.SQLException;

import javax.persistence.EntityManager;

/**
 * Interface fonctionnelle permettant d'instancier l'EntityManager avec des
 * types génériques
 *
 * @param <T>
 */
@FunctionalInterface
public interface IRunJPA<T> {
	/**
	 * @param entitymanager
	 * @return T
	 * @throws SQLException
	 */
	T exec(EntityManager entitymanager);
}
