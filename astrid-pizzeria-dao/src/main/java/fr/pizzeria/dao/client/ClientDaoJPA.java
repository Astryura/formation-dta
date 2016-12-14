package fr.pizzeria.dao.client;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.IRunJPA;
import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Client;

public class ClientDaoJPA implements ClientDao {

	private EntityManagerFactory emfactory;

	/**
	 * Constructeur instanciant le EntityManagerFactory
	 */
	public ClientDaoJPA() {
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
	public void saveNewClient(Client client) {
		execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(client);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}

	@Override
	public Client ConnectNewClient(Client client) {
		return execute((EntityManager entitymanager) -> {
			TypedQuery<Client> query = entitymanager
					.createQuery("SELECT c FROM Client c WHERE c.email = :email AND c.motDePasse = :mdp", Client.class);
			query.setParameter("email", client.getEmail());
			query.setParameter("mdp", client.getMotDePasse());
			Client cl = query.getSingleResult();
			if (cl != null) {
				return cl;
			} else {
				return null;
			}
		});
	}

	@Override
	public void close() {
		emfactory.close();
	}

}
