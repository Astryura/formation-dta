package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;

@Stateless
public class ClientServiceEJB {
	@PersistenceContext(unitName = "pizzeria-console")
	private EntityManager entitymanager;

	public List<Client> findAll() {
		TypedQuery<Client> query = entitymanager.createQuery("SELECT c FROM Client c", Client.class);
		return query.getResultList();
	}

	public void updateClient(Integer id, Client client) {
		TypedQuery<Client> query = entitymanager.createQuery("SELECT c FROM Client c WHERE c.id = :id", Client.class);
		query.setParameter("id", id);
		Client c = query.getSingleResult();
		c.setEmail(client.getEmail());
		c.setNom(client.getNom());
		c.setPrenom(client.getPrenom());
	}

	public void saveClient(Client client) {
		entitymanager.persist(client);
	}
}
