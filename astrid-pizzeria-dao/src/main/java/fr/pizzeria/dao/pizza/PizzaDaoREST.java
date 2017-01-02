package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import fr.pizzeria.model.Pizza;

public class PizzaDaoREST implements PizzaDao {
	private Client client = ClientBuilder.newClient(new ClientConfig());
	private String targetUrl = "http://localhost:8080/astrid-pizzeria-admin-app-1/api/rest/pizzas";

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> list = client.target(targetUrl).request().get(new GenericType<List<Pizza>>() {
		});
		Pizza.setNbPizzas(list.size());
		return list;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		client.target(targetUrl).request().post(Entity.entity(pizza, MediaType.APPLICATION_JSON), Pizza.class);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		client.target(targetUrl).path(codePizza).request().put(Entity.entity(pizza, MediaType.APPLICATION_JSON),
				Pizza.class);

	}

	@Override
	public void deletePizza(String codePizza) {
		client.target(targetUrl).path(codePizza).request().delete();

	}

	@Override
	public void close() {
		client.close();
	}

}
