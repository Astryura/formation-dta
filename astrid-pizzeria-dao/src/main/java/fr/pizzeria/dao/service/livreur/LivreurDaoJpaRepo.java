package fr.pizzeria.dao.service.livreur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repo.LivreurRepository;
import fr.pizzeria.model.Livreur;

@Component
public class LivreurDaoJpaRepo implements LivreurDao {
	@Autowired
	LivreurRepository livRepo;

	@Override
	public void addLivreur(Livreur livreur) {
		livRepo.save(livreur);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}
}
