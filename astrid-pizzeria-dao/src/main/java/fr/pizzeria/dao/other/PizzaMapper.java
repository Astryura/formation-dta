package fr.pizzeria.dao.other;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMapper implements RowMapper<Pizza> {

	@Override
	public Pizza mapRow(ResultSet resultats, int rowNum) throws SQLException {
		Integer id = resultats.getInt("ID");
		String code = resultats.getString("CODE");
		String name = resultats.getString("NOM");
		Double price = resultats.getDouble("PRIX");
		String cat = resultats.getString("CategoriePizza");
		return new Pizza(id, code, name, price, CategoriePizza.valueOf(cat.toUpperCase().replaceAll(" ", "_")));
	}

}
