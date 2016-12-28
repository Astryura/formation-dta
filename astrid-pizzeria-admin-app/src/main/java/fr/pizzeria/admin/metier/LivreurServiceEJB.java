package fr.pizzeria.admin.metier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Livreur;

@Stateless
public class LivreurServiceEJB {
	@PersistenceContext(unitName = "pizzeria-console")
	private EntityManager entitymanager;

	public void addLivreur(Livreur livreur) {
		entitymanager.persist(livreur);
	}
}
