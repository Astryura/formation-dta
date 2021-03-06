package fr.pizzeria.dao.service.livreur;

import javax.persistence.EntityManager;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.model.Livreur;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class LivreurDaoJPA implements LivreurDao {

	/**
	 * instantiation de JPADao
	 * 
	 * @see JPADao
	 * @see JPADao#JPADao()
	 */
	private JPADao jpaDao = new JPADao();

	@Override
	public void addLivreur(Livreur livreur) {
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
