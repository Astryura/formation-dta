package fr.pizzeria.dao.client;

import fr.pizzeria.dao.JPADao;
import fr.pizzeria.model.Client;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public interface ClientDao {
	/**
	 * 
	 * @param client
	 */
	void saveNewClient(Client client, JPADao jpaDao);

	/**
	 * 
	 * @param client
	 * @return Client
	 */

	Client ConnectNewClient(Client client, JPADao jpaDao);

}
