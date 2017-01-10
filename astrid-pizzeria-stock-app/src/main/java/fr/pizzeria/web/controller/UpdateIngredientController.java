package fr.pizzeria.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView formIngredient(@PathVariable Integer id, Model model) {
		ModelAndView mav = new ModelAndView();
		Ingredient ing = ingredientRepo.findById(id);
		mav.addObject("ingredient", ing);
		model.addAttribute("ingredient", ing);
		mav.setViewName("updateIngredient");
		return mav;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public RedirectView updateIngredient(@PathVariable Integer id,
			@ModelAttribute("ingredient") Ingredient ingredient) {
		Ingredient ing = ingredientRepo.findById(id);
		ing.setNom(ingredient.getNom());
		ing.setPrix(ingredient.getPrix());
		ing.setQuantite(ingredient.getQuantite());
		ingredientRepo.saveAndFlush(ing);
		return new RedirectView("../");
	}
}
