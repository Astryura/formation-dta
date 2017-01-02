package fr.pizzeria.admin.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaRessource {
	@Inject
	PizzaServiceEJB service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list() {
		return service.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void newPizza(Pizza pizza) {
		service.savePizza(pizza);
	}

	@Path("/{CODE}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePizza(@PathParam("CODE") String codePizza, Pizza pizza) {
		service.updatePizza(codePizza, pizza);
	}

	@Path("/{CODE}")
	@DELETE
	public void deletePizza(@PathParam("CODE") String codePizza) {
		service.deletePizza(codePizza);
	}
}
