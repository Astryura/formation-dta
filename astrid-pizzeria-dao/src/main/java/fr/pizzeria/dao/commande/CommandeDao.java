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
	 * @param codes
	 */
	void newCommande(Integer id, List<String> codes);

	/**
	 * 
	 * @param id
	 * @return List<Commande>
	 */
	List<Commande> listCommandeClient(Integer id);

	/**
	 * close
	 */
	void close();

	/**
	 * 
	 * @return List<Commande>
	 */
	List<Commande> listCommande();

	/**
	 * 
	 * @param num
	 */
	void expedtionCommande(Integer num);

}
