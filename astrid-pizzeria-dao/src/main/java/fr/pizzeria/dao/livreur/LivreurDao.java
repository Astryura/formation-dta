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
	void addLivreur(Livreur livreur);

	/**
	 * close
	 */
	void close();

}
