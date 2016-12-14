package fr.pizzeria.dao.livreur;

import fr.pizzeria.model.Livreur;

public interface LivreurDao {

	void AddLivreur(Livreur livreur);

	/**
	 * 
	 */
	void close();

}
