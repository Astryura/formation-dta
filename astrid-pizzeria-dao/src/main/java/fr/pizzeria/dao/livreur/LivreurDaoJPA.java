package fr.pizzeria.dao.livreur;

import javax.persistence.EntityManager;

import fr.pizzeria.dao.JPADao;
import fr.pizzeria.model.Livreur;

public class LivreurDaoJPA implements LivreurDao {

	@Override
	public void AddLivreur(Livreur livreur, JPADao jpaDao) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(livreur);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});

	}

	@Override
	public void close() {

	}
}
