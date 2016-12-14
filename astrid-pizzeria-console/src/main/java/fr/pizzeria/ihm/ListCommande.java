package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Commande;

public class ListCommande implements Action {

	private IhmUtil ihmUtil;
	private int num;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ListCommande(IhmUtil ihmUtil, int num) {
		super();
		this.ihmUtil = ihmUtil;
		this.num = num;
	}

	@Override
	public void doAction() {
		System.out.println("Liste des Commandes non traitées :");
		List<Commande> commandes = ihmUtil.getCommandeDao().ListCommande();
		commandes.forEach(commande -> {
			if (commande != null) {
				System.out.println(commande.getId() + ". " + commande.getNumeroCommande() + " "
						+ commande.getDateCommande() + " " + commande.getStatut());
			} else {
				System.out.println("erreur");
			}
		});

	}

	@Override
	public void describeAction() {
		System.out.println(num + ". Lister toutes les commandes non traitées");

	}

}