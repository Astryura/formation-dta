package fr.pizzeria.admin.event;

import fr.pizzeria.model.Pizza;

public class ModifierPizzaEvent {
	private String dateUpdate;
	private Pizza pizzaModifier;
	private Pizza pizza;

	public ModifierPizzaEvent(String dateUpdate, Pizza pizzaModifier, Pizza pizza) {
		super();
		this.dateUpdate = dateUpdate;
		this.pizzaModifier = pizzaModifier;
		this.pizza = pizza;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Pizza getPizzaModifier() {
		return pizzaModifier;
	}

	public void setPizzaModifier(Pizza pizzaModifier) {
		this.pizzaModifier = pizzaModifier;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
