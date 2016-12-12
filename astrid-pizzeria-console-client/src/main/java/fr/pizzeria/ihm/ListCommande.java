package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

public class ListCommande implements Action {

	private IhmUtilClient ihmUtil;
	private Client client;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ListCommande(IhmUtilClient ihmUtil, Client client) {
		super();
		this.ihmUtil = ihmUtil;
		this.client = client;
	}

	@Override
	public void doAction() {
		System.out.println("Votre Liste de Commande :");
		List<Commande> commandes = ihmUtil.getCommandeDao().ListCommande(client.getId());
		commandes.forEach(commande -> {
			if (commande != null) {
				System.out.println(commande.getId() + ". " + commande.getDateCommande());
			} else {
				System.out.println("erreur");
			}
		});

	}

	@Override
	public void describeAction() {
		System.out.println("2. Lister ses commandes");
	}
}
