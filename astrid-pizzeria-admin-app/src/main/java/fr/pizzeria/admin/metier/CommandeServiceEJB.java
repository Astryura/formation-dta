package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Commande;

@Stateless
public class CommandeServiceEJB {
	@PersistenceContext(unitName = "pizzeria-console")
	private EntityManager entitymanager;

	public List<Commande> findAll() {
		TypedQuery<Commande> query = entitymanager.createQuery("SELECT co FROM Commande co", Commande.class);
		return query.getResultList();
	}

	public void expedtionCommande(Integer num) {
		TypedQuery<Commande> query = entitymanager
				.createQuery("SELECT co FROM Commande co WHERE co.numeroCommande= :num", Commande.class);
		query.setParameter("num", num);
		Commande commande = query.getSingleResult();
		commande.setStatut(1);
	}
}
