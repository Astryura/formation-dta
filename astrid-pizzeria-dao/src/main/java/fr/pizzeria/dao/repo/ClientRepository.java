package fr.pizzeria.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	Client findById(Integer Id);

	Client findByEmailAndMotDePasse(String email, String motDePasse);
}
