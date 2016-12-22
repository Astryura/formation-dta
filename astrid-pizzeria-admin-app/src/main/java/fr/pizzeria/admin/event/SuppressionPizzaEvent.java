package fr.pizzeria.admin.event;

import fr.pizzeria.model.Pizza;

public class SuppressionPizzaEvent {

	private String dateDelete;
	private Pizza pizza;

	public SuppressionPizzaEvent(String dateDelete, Pizza pizza) {
		super();
		this.dateDelete = dateDelete;
		this.pizza = pizza;
	}

	public String getDateDelete() {
		return dateDelete;
	}

	public void setDateDelete(String dateDelete) {
		this.dateDelete = dateDelete;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
