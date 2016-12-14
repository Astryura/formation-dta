package fr.pizzeria.dao.commande;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class CommandeDaoJPA implements CommandeDao {
	private EntityManagerFactory emfactory;

	/**
	 * Constructeur instanciant le EntityManagerFactory
	 */
	public CommandeDaoJPA() {
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
	public void NewCommande(Integer id, String codePizza) {
		execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String today = dateFormat.format(date);
			Client client = entitymanager.find(Client.class, id);
			Livreur livreur = entitymanager.find(Livreur.class, 1);
			Commande commande = new Commande(124558, 0, today, client, livreur);
			TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code",
					Pizza.class);
			query.setParameter("code", codePizza);
			Pizza p = query.getSingleResult();
			commande.addPizza(p);
			entitymanager.persist(commande);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}

	@Override
	public void close() {
		emfactory.close();
	}

	@Override
	public List<Commande> ListCommandeClient(Integer id) {
		return execute((EntityManager entitymanager) -> {
			TypedQuery<Commande> query = entitymanager
					.createQuery("SELECT co FROM Commande co WHERE co.client.id = :id", Commande.class);
			query.setParameter("id", id);
			List<Commande> commandes = query.getResultList();
			if (commandes != null) {
				return commandes;
			} else {
				return null;
			}
		});
	}

	@Override
	public List<Commande> ListCommande() {
		return execute((EntityManager entitymanager) -> {
			TypedQuery<Commande> query = entitymanager.createQuery("SELECT co FROM Commande co WHERE co.statut=0",
					Commande.class);
			List<Commande> commandes = query.getResultList();
			if (commandes != null) {
				return commandes;
			} else {
				return null;
			}
		});
	}

	@Override
	public void ExpedtionCommande(Integer num) {
		execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			TypedQuery<Commande> query = entitymanager
					.createQuery("SELECT co FROM Commande co WHERE co.numeroCommande= :num", Commande.class);
			query.setParameter("num", num);
			Commande commande = query.getSingleResult();
			commande.setStatut(1);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}
}
