package fr.pizzeria.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	List<Commande> findByClientId(Integer idClient);

	List<Commande> findByStatut(Integer statut);

	Commande findByNumeroCommande(Integer numeroCommande);
}
