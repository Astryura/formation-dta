package fr.pizzeria.dao.livreur;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import fr.pizzeria.dao.IRunJPA;
import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Livreur;

public class LivreurDaoJPA implements LivreurDao {

	private EntityManagerFactory emfactory;

	/**
	 * Constructeur instanciant le EntityManagerFactory
	 */
	public LivreurDaoJPA() {
		emfactory = Persistence.createEntityManagerFactory("pizzeria-console");
	}

	/**
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

	@Override
	public void AddLivreur(Livreur livreur) {
		execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(livreur);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});

	}

	@Override
	public void close() {
		emfactory.close();
	}
}
