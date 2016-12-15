package fr.pizzeria.dao.livreur;

import javax.persistence.EntityManager;

import fr.pizzeria.dao.other.JDBCDao;
import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.model.Livreur;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class LivreurDaoJPA implements LivreurDao {

	/**
	 * @see JDBCDao#JDBCDao()
	 */
	private JPADao jpaDao;

	/**
	 * Constructeur instanciant le EntityManagerFactory
	 */
	public LivreurDaoJPA(JPADao jpaDao) {
		this.jpaDao = jpaDao;
	}

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
