package fr.pizzeria.dao.commande;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import fr.pizzeria.dao.client.ClientDaoTableau;
import fr.pizzeria.dao.livreur.LivreurDaoTableau;
import fr.pizzeria.dao.pizza.PizzaDaoTableau;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

public class CommandeDaoTableau implements CommandeDao {

	List<Livreur> listLivreurs = new ArrayList<>();
	List<Client> listClients = new ArrayList<>();
	List<Commande> listCommandes = new ArrayList<>();
	List<Pizza> listPizzas = new ArrayList<>();

	public CommandeDaoTableau() {
		LivreurDaoTableau lTab = new LivreurDaoTableau();
		listLivreurs = lTab.allLivreur();
		ClientDaoTableau cTab = new ClientDaoTableau();
		listClients = cTab.allClient();
		PizzaDaoTableau pTab = new PizzaDaoTableau();
		listPizzas = pTab.findAllPizzas();
	}

	@Override
	public void NewCommande(Integer id, String codePizza) {
		Optional<Client> findFirst = listClients.stream().filter(cl -> cl.getId().equals(id)).findFirst();
		Client client = null;
		if (findFirst.isPresent()) {
			client = findFirst.get();
		}
		Random random = new Random();
		int index = random.nextInt(listLivreurs.size());
		Optional<Livreur> findFirstL = listLivreurs.stream().filter(l -> l.getId().equals(index)).findFirst();
		Livreur livreur = null;
		if (findFirstL.isPresent()) {
			livreur = findFirstL.get();
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		Commande commande = new Commande(124558, 0, today, client, livreur);
		Optional<Pizza> findFirtP = listPizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();
		if (findFirtP.isPresent()) {
			Pizza pizza = findFirtP.get();
			commande.addPizza(pizza);
		}
		listCommandes.add(commande);
	}

	@Override
	public List<Commande> ListCommandeClient(Integer id) {
		Optional<Client> findFirst = listClients.stream().filter(cl -> cl.getId().equals(id)).findFirst();
		Client client = null;
		if (findFirst.isPresent()) {
			client = findFirst.get();
		}
		/*
		 * Optional<Commande> f = listCommandes.stream().filter(cl ->
		 * cl.equals(client)).findFirst(); if (findFirst.isPresent()) { client =
		 * findFirst.get(); }
		 */
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> ListCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ExpedtionCommande(Integer num) {
		// TODO Auto-generated method stub

	}

}
