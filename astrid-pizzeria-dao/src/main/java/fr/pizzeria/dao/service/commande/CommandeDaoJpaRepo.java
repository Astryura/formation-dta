package fr.pizzeria.dao.service.commande;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repo.ClientRepository;
import fr.pizzeria.dao.repo.CommandeRepository;
import fr.pizzeria.dao.repo.LivreurRepository;
import fr.pizzeria.dao.repo.pizza.PizzaRepository;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

@Component
public class CommandeDaoJpaRepo implements CommandeDao {
	@Autowired
	CommandeRepository comRepo;
	@Autowired
	ClientRepository clRepo;
	@Autowired
	LivreurRepository livRepo;
	@Autowired
	PizzaRepository pizRepo;
	private Random rand = new Random();

	@Override
	public void newCommande(Integer id, List<String> codes) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		Client client = clRepo.findById(id);
		List<Livreur> listLiv = livRepo.findAll();
		int nbLiv = listLiv.size();
		Livreur livreur;
		if (nbLiv != 0) {
			int randomNumLivreur = rand.nextInt((nbLiv - 1) + 1) + 1;
			livreur = livRepo.findById(randomNumLivreur);
		} else {
			livreur = new Livreur("Road", "Runner");
		}
		List<Commande> listCommandes = comRepo.findAll();
		Comparator<Commande> comp = Comparator.comparing(Commande::getNumeroCommande);
		Optional<Commande> com = listCommandes.stream().max(comp);
		Integer numcom;
		if (com.isPresent()) {
			numcom = com.get().getNumeroCommande() + 1;
		} else {
			numcom = 0;
		}
		Commande commande = new Commande(numcom, 0, today, client, livreur);
		for (String codePizza : codes) {
			Pizza p = pizRepo.findByCode(codePizza);
			commande.addPizza(p);
		}
		comRepo.save(commande);

	}

	@Override
	public List<Commande> listCommandeClient(Integer id) {
		return comRepo.findByClientId(id);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> listCommande() {
		return comRepo.findByStatut(0);
	}

	@Override
	public void expedtionCommande(Integer num) {
		Commande com = comRepo.findByNumeroCommande(num);
		comRepo.delete(com);
		com.setStatut(1);
		comRepo.save(com);

	}

}
