package fr.pizzeria.ihm;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class DeletePizza implements Action {

	private IhmUtil ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public DeletePizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		System.out.println("Supprimer votre Pizza. \nCode de la Pizza que vous voulez supprimer");
		String codeS = ihmUtil.getScanner().next();
		ihmUtil.getPizzaDao().deletePizza(codeS);

	}

	@Override
	public void describeAction() {
		System.out.println("4. Supprimer une pizza");
	}

}
