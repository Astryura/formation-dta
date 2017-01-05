package fr.pizzeria.dao.pizza;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.model.Pizza;

/**
 * Classe gérant les Pizza enregistrées en JPA
 * 
 * @author Astrid Hlavacek
 *
 */
@Component
@Qualifier("JPA")
public class PizzaDaoJPA implements PizzaDao {

	/**
	 * @see JPADao
	 * @see JPADao#JPADao()
	 */
	private JPADao jpaDao = new JPADao();

	@Override
	public void close() {
		jpaDao.close();
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return jpaDao.execute((EntityManager entitymanager) -> {
			TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p", Pizza.class);
			Pizza.setNbPizzas(query.getResultList().size());
			return query.getResultList();
		});
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(pizza);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code",
					Pizza.class);
			query.setParameter("code", codePizza);
			Pizza p = query.getSingleResult();
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
			p.setCatP(pizza.getCatP());
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}

	@Override
	public void deletePizza(String codePizza) {
		jpaDao.execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code",
					Pizza.class);
			query.setParameter("code", codePizza);
			Pizza p = query.getSingleResult();
			entitymanager.remove(p);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});

	}

	@Override
	public void importDataPizza() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String choix = bundle.getString("dao.source");
		PizzaDao pizzadao;
		try {
			pizzadao = (PizzaDao) Class.forName(choix).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			Logger.getLogger(PizzaDaoJDBC.class.getName()).severe(e1.getMessage());
			throw new PizzaException(e1);
		}
		jpaDao.execute((EntityManager entitymanager) -> {
			List<Pizza> listPizzas = pizzadao.findAllPizzas();
			for (Pizza pizza : listPizzas) {
				entitymanager.getTransaction().begin();
				entitymanager.merge(pizza);
				entitymanager.getTransaction().commit();
			}
			return Void.TYPE;
		});

	}
}
