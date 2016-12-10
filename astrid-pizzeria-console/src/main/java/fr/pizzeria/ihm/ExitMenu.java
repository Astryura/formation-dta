package fr.pizzeria.ihm;

public class ExitMenu implements Action {

	private IhmUtil ihmUtil;

	public ExitMenu(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		ihmUtil.getPizzaDao().close();
		System.out.println("AU REVOIR :'(");
	}

	@Override
	public void describeAction() {
		System.out.println("99. Sortir");
	}

}
