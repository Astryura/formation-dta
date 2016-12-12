package fr.pizzeria.ihm;

import fr.pizzeria.model.Client;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class Subscribe implements Action {

	private IhmUtilClient ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public Subscribe(IhmUtilClient ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		System.out.println("Inscrivez-vous : \nVotre nom");
		String nom = ihmUtil.getScanner().next();
		System.out.println("Votre prenom");
		String prenom = ihmUtil.getScanner().next();
		System.out.println("Votre email");
		String email = ihmUtil.getScanner().next();
		System.out.println("Votre mot de passe");
		String mdp = ihmUtil.getScanner().next();
		Client client = new Client(nom, prenom, email, mdp);
		ihmUtil.getCommandeDao().saveNewClient(client);

	}

	@Override
	public void describeAction() {
		System.out.println("1. S'inscrire");
	}

}
