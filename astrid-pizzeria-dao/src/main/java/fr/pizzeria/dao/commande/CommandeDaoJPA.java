package fr.pizzeria.dao.commande;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.JPADao;
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

	@Override
	public void NewCommande(Integer id, String codePizza, JPADao jpaDao) {
		jpaDao.execute((EntityManager entitymanager) -> {
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
	public List<Commande> ListCommandeClient(Integer id, JPADao jpaDao) {
		return jpaDao.execute((EntityManager entitymanager) -> {
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
	public List<Commande> ListCommande(JPADao jpaDao) {
		return jpaDao.execute((EntityManager entitymanager) -> {
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
	public void ExpedtionCommande(Integer num, JPADao jpaDao) {
		jpaDao.execute((EntityManager entitymanager) -> {
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

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}
}
