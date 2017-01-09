package fr.pizzeria.dao.service.client;

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
	void saveNewClient(Client client);

	/**
	 * 
	 * @param client
	 * @return Client
	 */

	Client connectNewClient(Client client);

	/**
	 * close console
	 */
	void close();

}
