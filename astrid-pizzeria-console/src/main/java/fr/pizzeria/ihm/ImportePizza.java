package fr.pizzeria.ihm;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ImportePizza implements Action {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ImportePizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		System.out.println("Voulez vous importez les données dans la base de données (oui ou non)");
		String choix = ihmUtil.getScanner().next();
		if (choix.equalsIgnoreCase("oui")) {
			ihmUtil.getPizzaDao().importDataPizza();
		}
	}

	@Override
	public void describeAction() {
		System.out.println("7. Importer les fichiers");
	}

}
