package fr.pizzeria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Pizza;

@RestController
@RequestMapping(value = "/pizzas")
public class ListPizzaController {
	@Autowired
	PizzaRepository pizzaRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Pizza> listPizzas() {
		return pizzaRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addPizza(@RequestBody Pizza pizza) {
		pizzaRepo.save(pizza);
	}
}
