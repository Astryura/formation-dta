package fr.pizzeria.ihm;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ExitMenu implements Action {

	private IhmUtilClient ihmUtil;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 */
	public ExitMenu(IhmUtilClient ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		ihmUtil.getCommandeDao().close();
		System.out.println("AU REVOIR :'(");
	}

	@Override
	public void describeAction() {
		System.out.println("99. Sortir");
	}

}
