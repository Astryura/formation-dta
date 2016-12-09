package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJPA implements PizzaDao {

	interface IRunSql<T> {
		T exec(EntityManager entitymanager) throws SQLException;
	}

	public <T> T execute(IRunSql<T> run) {
		EntityManagerFactory emfactory = null;
		EntityManager entitymanager = null;
		try {
			emfactory = Persistence.createEntityManagerFactory("pizzeria-console");
			entitymanager = emfactory.createEntityManager();
			return run.exec(entitymanager);
		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoJDBC.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		} finally {
			entitymanager.close();
			emfactory.close();
		}

	}

	@Override
	public List<Pizza> findAllPizzas() throws PizzaException {
		return execute((EntityManager entitymanager) -> {
			TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p", Pizza.class);
			return query.getResultList();
		});
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws PizzaException {
		execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			entitymanager.persist(pizza);
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws PizzaException {
		execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code",
					Pizza.class);
			query.setParameter("code", codePizza);
			Pizza p = (Pizza) query.getSingleResult();
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
			p.setCatP(CategoriePizza.valueOf(pizza.getCatP()));
			entitymanager.getTransaction().commit();
			return Void.TYPE;
		});
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		execute((EntityManager entitymanager) -> {
			entitymanager.getTransaction().begin();
			TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code",
					Pizza.class);
			query.setParameter("code", codePizza);
			Pizza p = (Pizza) query.getSingleResult();
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
