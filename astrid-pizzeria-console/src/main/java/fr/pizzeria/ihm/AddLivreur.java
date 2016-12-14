package fr.pizzeria.ihm;

import fr.pizzeria.model.Livreur;

public class AddLivreur implements Action {

	private IhmUtil ihmUtil;
	private int num;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public AddLivreur(IhmUtil ihmUtil, int num) {
		super();
		this.ihmUtil = ihmUtil;
		this.num = num;
	}

	@Override
	public void doAction() {
		System.out.println("Votre nom");
		String nom = ihmUtil.getScanner().next();
		System.out.println("Votre prenom");
		String prenom = ihmUtil.getScanner().next();
		Livreur livreur = new Livreur(nom, prenom);
		ihmUtil.getLivreurDao().AddLivreur(livreur);

	}

	@Override
	public void describeAction() {
		System.out.println(num + ". Ajouter	un	livreur");
	}
}
