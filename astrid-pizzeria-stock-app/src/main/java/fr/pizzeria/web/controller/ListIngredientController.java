package fr.pizzeria.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.model.Ingredient;
import fr.pizzeria.web.repo.IngredientRepository;

@RestController
@RequestMapping(value = "/ingredients")
public class ListIngredientController {
	@Autowired
	IngredientRepository ingredientRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listIngredient() {
		ModelAndView mav = new ModelAndView();
		List<Ingredient> ingredients = ingredientRepo.findAll();
		mav.addObject("ingredients", ingredients);
		mav.setViewName("listIngredient");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
		ModelAndView mav = new ModelAndView();
		ingredientRepo.save(ingredient);
		mav.addObject("ingredient", ingredient);
		mav.setViewName("listIngredient");
		return mav;

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ModelAndView updateIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
		return null;

	}
}
