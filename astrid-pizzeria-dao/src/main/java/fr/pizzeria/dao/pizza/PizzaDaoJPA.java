package fr.pizzeria.dao.pizza;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJPA implements PizzaDao {

	EntityManagerFactory emfactory;
	EntityManager entitymanager;

	public PizzaDaoJPA() {
		emfactory = Persistence.createEntityManagerFactory("pizzeria-console");
		entitymanager = emfactory.createEntityManager();

	}

	@Override
	public List<Pizza> findAllPizzas() throws PizzaException {
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p", Pizza.class);
		List<Pizza> listPizzas = query.getResultList();
		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws PizzaException {
		entitymanager.getTransaction().begin();
		entitymanager.persist(pizza);
		entitymanager.getTransaction().commit();
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws PizzaException {
		entitymanager.getTransaction().begin();
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza p = (Pizza) query.getSingleResult();
		p.setCode(pizza.getCode());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		p.setCatP(CategoriePizza.valueOf(pizza.getCatP()));
		entitymanager.getTransaction().commit();
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		entitymanager.getTransaction().begin();
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza p = (Pizza) query.getSingleResult();
		entitymanager.remove(p);
		entitymanager.getTransaction().commit();

	}

	@Override
	public List<Pizza> findAllPizzasCat() {
		List<Pizza> listPizzas = findAllPizzas();
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getCatP);
		List<Pizza> list = listPizzas.stream().sorted(comp).collect(Collectors.toList());
		return list;
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
