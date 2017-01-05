package fr.pizzeria.dao.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan("fr.pizzeria.dao.pizza")
public class PizzaDaoConfig {
	/*
	 * @Bean public DataSource datasource() { DriverManagerDataSource dataSource
	 * = new DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeriabd?useSSL=false");
	 * dataSource.setUsername("root"); dataSource.setPassword(""); return
	 * dataSource; }
	 */

	@Bean
	public DataSource datasource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();

	}

}
