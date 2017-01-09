package fr.pizzeria.dao.service.pizza.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.service.pizza.PizzaDao;
import fr.pizzeria.dao.service.pizza.PizzaDaoTableau;
import fr.pizzeria.model.Pizza;

@Component
@Qualifier("JPASpring")
public class PizzaDaoJpaSpring implements PizzaDao {
	@PersistenceContext
	EntityManager entitymanager;

	@Transactional
	@Override
	public List<Pizza> findAllPizzas() {
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p", Pizza.class);
		Pizza.setNbPizzas(query.getResultList().size());
		return query.getResultList();
	}

	@Transactional
	@Override
	public void saveNewPizza(Pizza pizza) {
		entitymanager.persist(pizza);

	}

	@Transactional
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza p = query.getSingleResult();
		p.setCode(pizza.getCode());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		p.setCatP(pizza.getCatP());
	}

	@Transactional
	@Override
	public void deletePizza(String codePizza) {
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza p = query.getSingleResult();
		entitymanager.remove(p);

	}

	@Override
	public void close() {
		entitymanager.close();
	}

	@Transactional
	@Override
	public void importDataPizza() {
		PizzaDao pizzadao = new PizzaDaoTableau();
		List<Pizza> listPizzas = pizzadao.findAllPizzas();
		for (Pizza pizza : listPizzas) {
			entitymanager.merge(pizza);
		}

	}
}
