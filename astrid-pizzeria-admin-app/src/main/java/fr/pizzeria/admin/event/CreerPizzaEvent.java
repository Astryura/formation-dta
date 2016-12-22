package fr.pizzeria.admin.event;

import fr.pizzeria.model.Pizza;

public class CreerPizzaEvent {

	private String dateCreation;
	private Pizza pizza;

	public CreerPizzaEvent(String dateCreation, Pizza pizza) {
		super();
		this.dateCreation = dateCreation;
		this.pizza = pizza;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
