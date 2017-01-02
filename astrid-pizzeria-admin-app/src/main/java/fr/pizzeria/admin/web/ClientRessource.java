package fr.pizzeria.admin.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.ClientServiceEJB;
import fr.pizzeria.model.Client;

@Path("/clients")
public class ClientRessource {
	@Inject
	ClientServiceEJB service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> list() {
		return service.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void newClient(Client client) {
		service.saveClient(client);
	}

	@Path("/{EMAIL}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateClient(@PathParam("EMAIL") String email, Client client) {
		service.updateClient(email, client);
	}
}
