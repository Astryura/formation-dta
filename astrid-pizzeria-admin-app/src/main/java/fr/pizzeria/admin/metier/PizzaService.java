package fr.pizzeria.admin.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SuppressionPizzaEvent;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	Event<CreerPizzaEvent> pizzaAdd;
	@Inject
	Event<ModifierPizzaEvent> pizzaUp;
	@Inject
	Event<SuppressionPizzaEvent> pizzaDel;

	@Inject
	@Named("pizzaDaoJPA")
	private PizzaDao pizzaDao;

	public List<Pizza> findAll() {
		return pizzaDao.findAllPizzas();
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		pizzaDao.updatePizza(codePizza, pizza);
	}

	public void savePizza(Pizza pizza) {
		pizzaDao.saveNewPizza(pizza);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		pizzaAdd.fire(new CreerPizzaEvent(today, pizza));
	}

	public void deletePizza(String codePizza) {
		pizzaDao.deletePizza(codePizza);
	}

}
