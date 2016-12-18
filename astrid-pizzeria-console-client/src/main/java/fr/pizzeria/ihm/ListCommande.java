package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ListCommande implements Action {

	private IhmUtil ihmUtil;
	/**
	 * Client connecté
	 */
	private Client client;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 * @param client
	 */
	public ListCommande(IhmUtil ihmUtil, Client client) {
		super();
		this.ihmUtil = ihmUtil;
		this.client = client;
	}

	@Override
	public void doAction() {
		System.out.println("Votre Liste de Commande :");
		List<Commande> commandes = ihmUtil.getCommandeDao().listCommandeClient(client.getId());
		for (Commande commande : commandes) {
			if (commande != null) {
				System.out.println(commande.getId() + ". " + commande.getNumeroCommande() + " "
						+ commande.getDateCommande() + " " + commande.getStatut());
				System.out.println("Vos Pizzas :");
				for (Pizza pizza : commande.getPizzas()) {
					System.out.println("Pizza : " + pizza.getCode() + " " + pizza.getNom() + " " + pizza.getPrix());
				}

			} else {
				System.out.println("erreur");
			}
		}

	}

	@Override
	public void describeAction() {
		System.out.println("2. Lister ses commandes");
	}
}
