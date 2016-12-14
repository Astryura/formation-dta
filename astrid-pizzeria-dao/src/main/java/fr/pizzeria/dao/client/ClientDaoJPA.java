package fr.pizzeria.dao.client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.JPADao;
import fr.pizzeria.model.Client;

public class ClientDaoJPA implements ClientDao {

	@Override
	public void saveNewClient(Client client, JPADao jpaDao) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(client);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});

	}

	@Override
	public Client ConnectNewClient(Client client, JPADao jpaDao) {
		return jpaDao.execute((EntityManager entitymanager) -> {
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

}
