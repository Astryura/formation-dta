package fr.pizzeria.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur, Integer> {
	Livreur findById(Integer Id);
}
