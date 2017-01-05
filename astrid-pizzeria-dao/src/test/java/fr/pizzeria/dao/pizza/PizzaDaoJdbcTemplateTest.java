package fr.pizzeria.dao.pizza;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.config.PizzaDaoConfig;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoConfig.class)
public class PizzaDaoJdbcTemplateTest {

	@Autowired
	PizzaDao pizzaDao;

	@Test
	public void saveNewPizzaTest() {
		Pizza p = new Pizza("HAR", "Harissa", 14.56, CategoriePizza.VIANDE);
		pizzaDao.saveNewPizza(p);
		List<Pizza> list = pizzaDao.findAllPizzas();
		Optional<Pizza> pizza = list.stream().filter(piz -> piz.getCode().equals(p.getCode())).findFirst();
		if (pizza.isPresent()) {
			pizza.get().equals(p);
		}
	}

	@Test
	public void updatePizzaTest() {
		Pizza p = new Pizza(7, "IND", "Indienne", 13.2, CategoriePizza.POISSON);
		String code = "IND";
		pizzaDao.updatePizza(code, p);
		List<Pizza> list = pizzaDao.findAllPizzas();
		Optional<Pizza> pizza = list.stream().filter(piz -> piz.getCode().equals(p.getCode())).findFirst();
		if (pizza.isPresent()) {
			pizza.get().equals(p);
		}

	}

	@Test
	public void deletePizzaTest() {
		Pizza p = new Pizza("PAR", "Party", 14.56, CategoriePizza.VIANDE);
		pizzaDao.saveNewPizza(p);
		String code = "PAR";
		pizzaDao.deletePizza(code);
		List<Pizza> list = pizzaDao.findAllPizzas();
		Optional<Pizza> pizza = list.stream().filter(piz -> piz.getCode().equals(code)).findFirst();
		if (pizza.isPresent()) {
			fail("N'a pas été supprimée");
		}
	}

}
