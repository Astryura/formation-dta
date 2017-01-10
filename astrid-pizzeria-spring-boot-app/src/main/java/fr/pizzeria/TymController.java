package fr.pizzeria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.model.Pizza;

@RestController
@RequestMapping(value = "/pizzas/tym")
public class TymController {
	@Autowired
	PizzaRepository pizzaRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listPizzas() {
		List<Pizza> pizzas = pizzaRepo.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("pizzas", pizzas);
		mav.setViewName("listPizza");
		return mav;

	}

}
