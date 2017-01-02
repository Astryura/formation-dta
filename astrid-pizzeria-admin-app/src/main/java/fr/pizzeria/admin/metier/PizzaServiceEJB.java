package fr.pizzeria.admin.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SuppressionPizzaEvent;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String today = dateFormat.format(date);
	@Inject
	Event<CreerPizzaEvent> pizzaAdd;
	@Inject
	Event<ModifierPizzaEvent> pizzaUp;
	@Inject
	Event<SuppressionPizzaEvent> pizzaDel;

	@PersistenceContext(unitName = "pizzeria-console")
	private EntityManager entitymanager;

	public List<Pizza> findAll() {
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p", Pizza.class);
		Pizza.setNbPizzas(query.getResultList().size());
		return query.getResultList();
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza p = query.getSingleResult();
		Pizza old = new Pizza(p.getCode(), p.getNom(), p.getPrix(),
				CategoriePizza.valueOf(p.getCatP().toUpperCase().replaceAll(" ", "_")));
		p.setCode(pizza.getCode());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		p.setImage(pizza.getImage());
		p.setCatP(CategoriePizza.valueOf(pizza.getCatP().toUpperCase().replaceAll(" ", "_")));
		pizzaUp.fire(new ModifierPizzaEvent(today, old, pizza));

	}

	public void savePizza(Pizza pizza) {
		entitymanager.persist(pizza);
		pizzaAdd.fire(new CreerPizzaEvent(today, pizza));
	}

	public void deletePizza(String codePizza) {
		TypedQuery<Pizza> query = entitymanager.createQuery("SELECT p FROM Pizza p WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza p = query.getSingleResult();
		pizzaDel.fire(new SuppressionPizzaEvent(today, p));
		entitymanager.remove(p);
	}
}
