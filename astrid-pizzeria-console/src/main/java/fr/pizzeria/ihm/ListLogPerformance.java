package fr.pizzeria.ihm;

public class ListLogPerformance implements Action {
	private IhmUtil ihmUtil;
	/**
	 * numérotation du menu
	 */
	private int num;

	/**
	 * Constructeur
	 * 
	 * @param ihmUtil
	 * @param num
	 */
	public ListLogPerformance(IhmUtil ihmUtil, int num) {
		super();
		this.ihmUtil = ihmUtil;
		this.num = num;
	}

	@Override
	public void doAction() {
		System.out.println("Liste des Logs :");
		ihmUtil.getPerfoRepo().findAll().forEach(perf -> {
			System.out.println("Service : " + perf.getService() + "   Date : " + perf.getDate()
					+ "    Temps d'execution : " + perf.getTempsExecution());
		});

	}

	@Override
	public void describeAction() {
		System.out.println(num + ". Liste des logs");

	}

}
