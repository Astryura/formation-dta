package fr.pizzeria.dao.livreur;

import fr.pizzeria.dao.JPADao;
import fr.pizzeria.model.Livreur;

public interface LivreurDao {

	void AddLivreur(Livreur livreur, JPADao jpaDao);

	/**
	 * 
	 */
	void close();

}
