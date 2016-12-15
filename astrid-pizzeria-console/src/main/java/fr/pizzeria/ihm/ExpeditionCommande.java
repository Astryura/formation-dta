package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Commande;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ExpeditionCommande implements Action {

	private IhmUtil ihmUtil;
	private int num;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ExpeditionCommande(IhmUtil ihmUtil, int num) {
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
		System.out.println("Saisissez le numéro de la commande a envoyer :");
		String numeroCommande = ihmUtil.getScanner().next();
		ihmUtil.getCommandeDao().ExpedtionCommande(Integer.parseInt(numeroCommande));

	}

	@Override
	public void describeAction() {
		System.out.println(num + ". Expédier une commande");
	}
}
