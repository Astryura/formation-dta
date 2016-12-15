package fr.pizzeria.dao.pizza;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe gérant les Pizza enregistrées en JPA
 * 
 * @author Astrid Hlavacek
 *
 */
public class PizzaDaoJPA implements PizzaDao {

	private JPADao jpaDao;

	/**
	 * Constructeur instanciant le EntityManagerFactory
	 */
	public PizzaDaoJPA(JPADao jpaDao) {
		this.jpaDao = jpaDao;
	}

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
			p.setCatP(CategoriePizza.valueOf(pizza.getCatP()));
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
	public List<Pizza> findAllPizzasCat() {
		List<Pizza> listPizzas = findAllPizzas();
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getCatP);
		return listPizzas.stream().sorted(comp).collect(Collectors.toList());

	}

	@Override
	public Pizza findPrixMaxPizza() {
		List<Pizza> listPizzas = findAllPizzas();
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getPrix);
		Optional<Pizza> pizza = listPizzas.stream().max(comp);
		if (pizza.isPresent()) {
			return pizza.get();
		} else {
			return null;
		}
	}

}
