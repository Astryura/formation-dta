package fr.pizzeria.dao.other;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class JPADao {

	private EntityManagerFactory emfactory;

	/**
	 * Constructeur instanciant le EntityManagerFactory
	 */
	public JPADao() {
		emfactory = Persistence.createEntityManagerFactory("pizzeria-console");
	}

	/**
	 * instanciation de l'interface fonctionnelle
	 * 
	 * @param run
	 * @return T
	 */
	public <T> T execute(IRunJPA<T> run) {
		EntityManager entitymanager = null;
		try {
			entitymanager = emfactory.createEntityManager();
			return run.exec(entitymanager);
		} catch (PersistenceException e) {
			Logger.getLogger(PizzaDaoJPA.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		} finally {
			if (entitymanager != null) {
				entitymanager.close();
			}
		}

	}

	/**
	 * close le EntityManagerFactory
	 */
	public void close() {
		emfactory.close();
	}
}
