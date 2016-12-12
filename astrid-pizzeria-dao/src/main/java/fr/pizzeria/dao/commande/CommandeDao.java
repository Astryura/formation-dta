package fr.pizzeria.dao.commande;

import java.util.List;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

public interface CommandeDao {
	void saveNewClient(Client client) throws PizzaException;

	Client ConnectNewClient(Client client) throws PizzaException;

	void NewCommande(Integer id, String codePizza) throws PizzaException;

	List<Commande> ListCommande(Integer id) throws PizzaException;

	void close();

}
