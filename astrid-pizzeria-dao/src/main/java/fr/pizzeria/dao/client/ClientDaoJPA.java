package fr.pizzeria.dao.client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.model.Client;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ClientDaoJPA implements ClientDao {

	/**
	 * instantiation de JPADao
	 * 
	 * @see JPADao
	 * @see JPADao#JPADao()
	 */
	private JPADao jpaDao;

	/**
	 * Constructeur
	 * 
	 * @param jpaDao
	 */
	public ClientDaoJPA(JPADao jpaDao) {
		this.jpaDao = jpaDao;
	}

	@Override
	public void saveNewClient(Client client) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(client);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});

	}

	@Override
	public Client connectNewClient(Client client) {
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

	@Override
	public void close() {
		jpaDao.close();
	}

}
