package fr.pizzeria.dao.commande;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.other.JPADao;
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

	private Random rand = new Random();
	/**
	 * instantiation de JPADao
	 * 
	 * @see JPADao
	 * @see JPADao#JPADao()
	 */
	private JPADao jpaDao = new JPADao();

	@Override
	public void newCommande(Integer id, List<String> codes) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String today = dateFormat.format(date);
			Client client = entitymanager.find(Client.class, id);
			TypedQuery<Livreur> querylivreur = entitymanager.createQuery("SELECT l FROM Livreur l", Livreur.class);
			int nbLiv = querylivreur.getResultList().size();
			int randomNumLivreur = rand.nextInt((nbLiv - 1) + 1) + 1;
			Livreur livreur = entitymanager.find(Livreur.class, randomNumLivreur);
			TypedQuery<Commande> querycom = entitymanager.createQuery("SELECT c FROM Commande c", Commande.class);
			List<Commande> listCommandes = querycom.getResultList();
			Comparator<Commande> comp = Comparator.comparing(Commande::getNumeroCommande);
			Optional<Commande> com = listCommandes.stream().max(comp);
			Integer numcom;
			if (com.isPresent()) {
				numcom = com.get().getNumeroCommande() + 1;
			} else {
				numcom = 0;
			}
			Commande commande = new Commande(numcom, 0, today, client, livreur);
			for (String codePizza : codes) {
				TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code",
						Pizza.class);
				query.setParameter("code", codePizza);
				Pizza p = query.getSingleResult();
				commande.addPizza(p);
			}
			entitymanager.persist(commande);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}

	@Override
	public List<Commande> listCommandeClient(Integer id) {
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
	public List<Commande> listCommande() {
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
	public void expedtionCommande(Integer num) {
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
		jpaDao.close();
	}
}
