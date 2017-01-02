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

	public void updateClient(String email, Client client) {
		TypedQuery<Client> query = entitymanager.createQuery("SELECT c FROM Client c WHERE c.email = :email",
				Client.class);
		query.setParameter("email", email);
		Client c = query.getSingleResult();
		c.setEmail(client.getEmail());
		c.setMotDePasse(client.getMotDePasse());
		c.setNom(client.getNom());
		c.setPrenom(client.getPrenom());
	}

	public void saveClient(Client client) {
		entitymanager.persist(client);
	}
}
