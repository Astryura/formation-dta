package fr.pizzeria.dao.livreur;

import javax.persistence.EntityManager;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.model.Livreur;

public class LivreurDaoJPA implements LivreurDao {

	private JPADao jpaDao;

	/**
	 * Constructeur instanciant le EntityManagerFactory
	 */
	public LivreurDaoJPA(JPADao jpaDao) {
		this.jpaDao = jpaDao;
	}

	@Override
	public void AddLivreur(Livreur livreur) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(livreur);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});

	}

	@Override
	public void close() {
		jpaDao.close();
	}
}
