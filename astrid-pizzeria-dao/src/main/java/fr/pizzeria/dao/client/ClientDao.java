package fr.pizzeria.dao.client;

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

	Client ConnectNewClient(Client client);

	void close();

}
