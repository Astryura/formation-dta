package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
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
		List<Commande> commandes = ihmUtil.getCommandeDao().ListCommandeClient(client.getId(), ihmUtil.getJpaDao());
		commandes.forEach(commande -> {
			if (commande != null) {
				System.out.println(commande.getId() + ". " + commande.getDateCommande() + " " + commande.getStatut());
				// System.out.println("Vos Pizzas :");
				/*
				 * Iterator<Pizza> iterator = commande.getPizzas().iterator();
				 * while (iterator.hasNext()) { Pizza p = iterator.next();
				 * System.out.println(p.getId() + ". " + p.getCode() + " " +
				 * p.getNom()); }
				 */

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
