package fr.pizzeria.dao.commande;

import java.util.List;

import fr.pizzeria.dao.JPADao;
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
	void NewCommande(Integer id, String codePizza, JPADao jpaDao);

	/**
	 * 
	 * @param id
	 * @return List<Commande>
	 */
	List<Commande> ListCommandeClient(Integer id, JPADao jpaDao);

	/**
	 * 
	 */
	void close();

	/**
	 * 
	 * @return List<Commande>
	 */
	List<Commande> ListCommande(JPADao jpaDao);

	void ExpedtionCommande(Integer num, JPADao jpaDao);

}
