package fr.pizzeria.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.pizzeria.model.Ingredient;
import fr.pizzeria.web.repo.IngredientRepository;

@RestController
@RequestMapping(value = "/ingredients/edit")
public class UpdateIngredientController {
	@Autowired
	IngredientRepository ingredientRepo;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView formIngredient(@RequestParam String id, @RequestParam String nom, @RequestParam String prix,
			@RequestParam String quantite) {
		ModelAndView mav = new ModelAndView();
		Ingredient ing = new Ingredient(Integer.parseInt(id), nom, Double.parseDouble(prix),
				Integer.parseInt(quantite));
		mav.addObject("ingredient", ing);
		mav.setViewName("updateIngredient");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public RedirectView updateIngredient(@RequestParam String id, @RequestParam String nom, @RequestParam String prix,
			@RequestParam String quantite) {
		Ingredient ing = ingredientRepo.findById(Integer.parseInt(id));
		ingredientRepo.delete(ing);
		Ingredient ingredient = new Ingredient(Integer.parseInt(id), nom, Double.parseDouble(prix),
				Integer.parseInt(quantite));
		ingredientRepo.save(ingredient);
		return new RedirectView("./");
	}
}
