package fr.pizzeria.dao.service.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.model.Client;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ClientDaoTableau implements ClientDao {

	/**
	 * intialise la liste de clients
	 */
	List<Client> listClients = new ArrayList<>();

	/**
	 * constructeur
	 */
	public ClientDaoTableau() {
		listClients.add(new Client(0, "Girard", "Jean", "J.Girard@hotmail.fr", "abc"));
	}

	/**
	 * Liste des clients
	 * 
	 * @return List<Client>
	 */
	public List<Client> allClient() {
		return listClients;
	}

	@Override
	public void saveNewClient(Client client) {
		Comparator<Client> comp = Comparator.comparing(Client::getId);
		Optional<Client> cl = listClients.stream().max(comp);
		if (cl.isPresent()) {
			Client max = cl.get();
			client.setId(max.getId() + 1);
			listClients.add(client);
		}
	}

	@Override
	public Client connectNewClient(Client client) {
		Optional<Client> findFirst = listClients.stream().filter(cl -> cl.getEmail().equals(client.getEmail()))
				.filter(cl -> cl.getMotDePasse().equals(client.getMotDePasse())).findFirst();

		if (findFirst.isPresent()) {
			return findFirst.get();
		} else {
			return null;
		}
	}

	@Override
	public void close() {
		listClients.clear();
	}

}
