package fr.pizzeria.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.dao.repo.IngredientRepository;
import fr.pizzeria.model.Ingredient;

@RestController
@RequestMapping(value = "/rest/ingredients")
public class IngredientControllerAPI {
	@Autowired
	IngredientRepository ingredientRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingredient> listIngredient() {
		return ingredientRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addIngredient(@RequestBody Ingredient ingredient) {
		ingredientRepo.save(ingredient);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void updateIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
		Ingredient ing = ingredientRepo.findById(id);
		ingredientRepo.delete(ing);
		ingredientRepo.save(ingredient);
	}
}
