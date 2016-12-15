package fr.pizzeria.dao.livreur;

import fr.pizzeria.model.Livreur;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public interface LivreurDao {

	/**
	 * 
	 * @param livreur
	 */
	void AddLivreur(Livreur livreur);

	/**
	 * 
	 */
	void close();

}
