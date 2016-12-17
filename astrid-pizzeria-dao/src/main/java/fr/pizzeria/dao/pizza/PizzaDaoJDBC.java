package fr.pizzeria.dao.pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.other.JDBCDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe gérant les Pizza enregistrées en JDBC
 * 
 * @author Astrid Hlavacek
 *
 */
public class PizzaDaoJDBC implements PizzaDao {

	/**
	 * @see JDBCDao
	 * @see JDBCDao#JDBCDao()
	 */
	private JDBCDao jdbcDao;

	/**
	 * Constructeur
	 * 
	 * @param jdbcDao
	 */
	public PizzaDaoJDBC(JDBCDao jdbcDao) {
		this.jdbcDao = jdbcDao;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> listPizzas = new ArrayList<>();
		return jdbcDao.execute((Connection connection, Statement statement) -> {
			Pizza.setNbPizzas(0);
			ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");
			while (resultats.next()) {
				Integer id = resultats.getInt("ID");
				String code = resultats.getString("CODE");
				String name = resultats.getString("NOM");
				Double price = resultats.getDouble("PRIX");
				String cat = resultats.getString("CategoriePizza");
				Pizza pizza = new Pizza(id, code, name, price,
						CategoriePizza.valueOf(cat.toUpperCase().replaceAll(" ", "_")));
				listPizzas.add(pizza);
			}
			Pizza.setNbPizzas(listPizzas.size());
			return listPizzas;
		});
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		jdbcDao.execute((Connection connection, Statement statement) -> {
			PreparedStatement addPizzaSt = connection
					.prepareStatement("INSERT INTO PIZZA (CODE, NOM, PRIX, CategoriePizza) VALUES (?,?,?,?)");
			addPizzaSt.setString(1, pizza.getCode());
			addPizzaSt.setString(2, pizza.getNom());
			addPizzaSt.setDouble(3, pizza.getPrix());
			addPizzaSt.setString(4, pizza.getCatP());
			addPizzaSt.executeUpdate();
			return Void.TYPE;
		});

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		jdbcDao.execute((Connection connection, Statement statement) -> {
			PreparedStatement updatePizzaSt = connection
					.prepareStatement("UPDATE PIZZA SET ID=?,CODE=?,NOM=?,PRIX=?,CategoriePizza=? WHERE CODE = ?");
			updatePizzaSt.setInt(1, pizza.getId());
			updatePizzaSt.setString(2, pizza.getCode());
			updatePizzaSt.setString(3, pizza.getNom());
			updatePizzaSt.setDouble(4, pizza.getPrix());
			updatePizzaSt.setString(5, pizza.getCatP());
			updatePizzaSt.setString(6, codePizza);
			updatePizzaSt.executeUpdate();
			return Void.TYPE;
		});
	}

	@Override
	public void deletePizza(String codePizza) {
		jdbcDao.execute((Connection connection, Statement statement) -> {
			PreparedStatement deletePizzaSt = connection.prepareStatement("DELETE FROM PIZZA WHERE CODE = ?");
			deletePizzaSt.setString(1, codePizza);
			deletePizzaSt.executeUpdate();
			return Void.TYPE;
		});

	}

	@Override
	public List<Pizza> findAllPizzasCat() {
		List<Pizza> listPizzas = findAllPizzas();
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getCatP);
		return listPizzas.stream().sorted(comp).collect(Collectors.toList());
	}

	@Override
	public Pizza findPrixMaxPizza() {
		List<Pizza> listPizzas = findAllPizzas();
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getPrix);
		Optional<Pizza> pizza = listPizzas.stream().max(comp);
		if (pizza.isPresent()) {
			return pizza.get();
		} else {
			return null;
		}
	}

	@Override
	public void importDataPizza() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String choix = bundle.getString("dao.source");
		PizzaDao pizzadao;
		try {
			pizzadao = (PizzaDao) Class.forName(choix).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			Logger.getLogger(PizzaDaoJDBC.class.getName()).severe(e1.getMessage());
			throw new PizzaException(e1);
		}
		List<Pizza> listPizzas = pizzadao.findAllPizzas();
		jdbcDao.execute((Connection connection, Statement statement) -> {
			connection.setAutoCommit(false);
			try {
				for (List<Pizza> liste : ListUtils.partition(listPizzas, 3)) {
					for (Pizza pizza : liste) {
						PreparedStatement addPizzaSt = connection.prepareStatement(
								"INSERT INTO PIZZA (CODE, NOM, PRIX, CategoriePizza) VALUES (?,?,?,?)");
						addPizzaSt.setString(1, pizza.getCode());
						addPizzaSt.setString(2, pizza.getNom());
						addPizzaSt.setDouble(3, pizza.getPrix());
						addPizzaSt.setString(4, pizza.getCatP());
						addPizzaSt.executeUpdate();

					}
					connection.commit();
				}
			} catch (SQLException e) {
				connection.rollback();
				Logger.getLogger(PizzaDaoJDBC.class.getName()).severe(e.getMessage());
				throw new PizzaException(e);
			}
			return Void.TYPE;
		});

	}

	@Override
	public void close() {
		Pizza.setNbPizzas(0);
	}

}
