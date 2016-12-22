package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SuppressionPizzaEvent;

@ApplicationScoped
public class TechniqueService {
	private List<CreerPizzaEvent> listAdd = new ArrayList<>();
	private List<ModifierPizzaEvent> listUp = new ArrayList<>();
	private List<SuppressionPizzaEvent> listDel = new ArrayList<>();

	public void ecouteAddPizza(@Observes CreerPizzaEvent event) {
		listAdd.add(event);

	}

	public void ecouteUpPizza(@Observes ModifierPizzaEvent event) {
		listUp.add(event);

	}

	public void ecouteDelPizza(@Observes SuppressionPizzaEvent event) {
		listDel.add(event);

	}

	public List<CreerPizzaEvent> getListAdd() {
		return listAdd;
	}

	public List<ModifierPizzaEvent> getListUp() {
		return listUp;
	}

	public List<SuppressionPizzaEvent> getListDel() {
		return listDel;
	}

}
