package fr.pizzeria.ihm;

import fr.pizzeria.model.Client;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class Connexion implements Action {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public Connexion(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		System.out.println("Connectez-vous : \nVotre email");
		String email = ihmUtil.getScanner().next();
		System.out.println("Votre mot de passe");
		String mdp = ihmUtil.getScanner().next();
		Client client = new Client(email, mdp);
		Client connect = ihmUtil.getClientDao().connectNewClient(client);
		if (connect != null) {
			System.out.println("vous etes connecté");
			new MainMenuClient2(ihmUtil, connect).displayMenu();
		} else {
			System.out.println("erreur");
			new MainMenuClient(ihmUtil).displayMenu();
		}

	}

	@Override
	public void describeAction() {
		System.out.println("2. Se connecter");
	}

}
