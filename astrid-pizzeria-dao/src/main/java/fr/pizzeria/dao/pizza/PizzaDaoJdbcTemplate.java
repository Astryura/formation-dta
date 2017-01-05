package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import fr.pizzeria.mapper.PizzaMapper;
import fr.pizzeria.model.Pizza;

@Component
public class PizzaDaoJdbcTemplate implements PizzaDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Pizza> findAllPizzas() {
		String sql = "SELECT * FROM PIZZA";
		return this.jdbcTemplate.query(sql, new PizzaMapper());
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		String sql = "INSERT INTO PIZZA (CODE, NOM, PRIX, CategoriePizza) VALUES (?,?,?,?)";
		this.jdbcTemplate.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCatP().name());
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		String sql = "UPDATE PIZZA SET ID=?,CODE=?,NOM=?,PRIX=?,CategoriePizza=? WHERE CODE = ?";
		this.jdbcTemplate.update(sql, pizza.getId(), pizza.getCode(), pizza.getNom(), pizza.getPrix(),
				pizza.getCatP().name(), codePizza);
	}

	@Override
	public void deletePizza(String codePizza) {
		String sql = "DELETE FROM PIZZA WHERE CODE = ?";
		this.jdbcTemplate.update(sql, codePizza);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
