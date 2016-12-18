package fr.pizzeria.dao.pizza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe gérant les Pizza enregistrées sous forme de fichier
 * 
 * @author Astrid Hlavacek
 *
 */
public class PizzaDaoFichier implements PizzaDao {

	private List<Pizza> listPizzas = new ArrayList<>();
	private static String dir = "data/";

	/**
	 * Constructeur
	 */
	public PizzaDaoFichier() {
		List<String> listFichiers = lire();
		listFichiers.forEach(s -> {
			File f = new File(s);
			if (f.canRead()) {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
					String ligne = br.readLine();
					String code = f.getName().replaceAll(".txt", "");
					String[] a = ligne.split(";");
					Pizza pizza = new Pizza(Integer.parseInt(a[0]), code, a[1], Double.parseDouble(a[2]),
							CategoriePizza.valueOf(a[3].toUpperCase().replaceAll(" ", "_")));
					listPizzas.add(pizza);
					br.close();
				} catch (Exception e) {
					Logger.getLogger(PizzaDaoFichier.class.getName()).severe(e.getMessage());
					throw new PizzaException(e);
				}
			}
		});
		Pizza.setNbPizzas(listPizzas.size());
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getId);
		listPizzas = listPizzas.stream().sorted(comp).collect(Collectors.toList());
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getId);
		Optional<Pizza> p = listPizzas.stream().max(comp);
		if (p.isPresent()) {
			Pizza max = p.get();
			pizza.setId(max.getId() + 1);
			listPizzas.add(pizza);
			Pizza.setNbPizzas(listPizzas.size());
			stockage(pizza);
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		listPizzas.forEach(p -> {
			if (p.getCode().equals(codePizza)) {
				pizza.setId(p.getId());
				int a = listPizzas.indexOf(p);
				listPizzas.set(a, pizza);
				destockage(p);
				stockage(pizza);
			}
		});

	}

	@Override
	public void deletePizza(String codePizza) {

		Optional<Pizza> findFirst = listPizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();

		if (findFirst.isPresent()) {
			Pizza pizza = findFirst.get();
			listPizzas.remove(pizza);
			destockage(pizza);
		}
		Pizza.setNbPizzas(listPizzas.size());

	}

	/**
	 * Enregistre un fichier Pizza
	 * 
	 * @param pizza
	 */
	public void stockage(Pizza pizza) {

		File file = new File(dir + pizza.getCode() + ".txt");
		Path path = file.toPath();
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(pizza.getId() + ";" + pizza.getNom() + ";" + pizza.getPrix() + ";" + pizza.getCatP());
		}

		catch (IOException e) {
			Logger.getLogger(PizzaDaoFichier.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}
	}

	/**
	 * Supprime un fichier Pizza
	 * 
	 * @param pizza
	 */
	public void destockage(Pizza pizza) {
		File fichier = new File(dir + pizza.getCode() + ".txt");
		if (fichier.delete()) {
			System.out.println("pizza supprimée");
		} else {
			System.out.println("erreur");
		}
	}

	/**
	 * Fait la liste des fichiers textes contenant des Pizza
	 * 
	 * @return List<String>
	 */
	public static List<String> lire() {

		final List<String> files = new ArrayList<>();

		Path path = Paths.get(dir);
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(path);
			for (Path entry : stream) {
				files.add(entry.toString());
			}
			stream.close();
		} catch (IOException e) {
			Logger.getLogger(PizzaDaoFichier.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}
		return files;

	}

	@Override
	public void close() {
		Pizza.setNbPizzas(0);
		listPizzas.clear();
	}

}