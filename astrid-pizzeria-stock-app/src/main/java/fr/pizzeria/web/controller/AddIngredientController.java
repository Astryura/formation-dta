package fr.pizzeria.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.pizzeria.dao.repo.IngredientRepository;
import fr.pizzeria.model.Ingredient;

@RestController
@RequestMapping(value = "/ingredients/add")
public class AddIngredientController {
	@Autowired
	IngredientRepository ingredientRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView formIngredient(Model model) {
		ModelAndView mav = new ModelAndView();
		List<Ingredient> ingredients = ingredientRepo.findAll();
		Ingredient ing = new Ingredient();
		mav.addObject("ingredients", ingredients);
		model.addAttribute("ingredient", ing);
		mav.setViewName("addIngredient");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public RedirectView addIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
		ingredientRepo.save(ingredient);
		return new RedirectView("./");

	}
}
