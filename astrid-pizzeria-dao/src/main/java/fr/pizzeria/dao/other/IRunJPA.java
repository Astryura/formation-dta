package fr.pizzeria.dao.other;

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
	 */
	T exec(EntityManager entitymanager);
}
