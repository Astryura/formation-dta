package fr.pizzeria.dao.commande;

import java.util.List;

import fr.pizzeria.model.Commande;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public interface CommandeDao {

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

	/**
	 * 
	 * @param num
	 */
	void ExpedtionCommande(Integer num);

}
