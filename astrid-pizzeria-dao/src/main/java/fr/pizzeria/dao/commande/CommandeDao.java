package fr.pizzeria.dao.commande;

import java.util.List;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public interface CommandeDao {

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

	/**
	 * 
	 * @param id
	 * @param codePizza
	 */
	void NewCommande(Integer id, String codePizza);

	/**
	 * 
	 * @param id
	 * @return List<Commande>
	 */
	List<Commande> ListCommandeClient(Integer id);

	/**
	 * 
	 */
	void close();

	/**
	 * 
	 * @return List<Commande>
	 */
	List<Commande> ListCommande();

}
