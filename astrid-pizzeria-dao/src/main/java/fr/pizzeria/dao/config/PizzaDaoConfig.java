package fr.pizzeria.dao.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao.repo")
@EnableAspectJAutoProxy
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
		// .addScript("schema.sql")
		return builder.setType(EmbeddedDatabaseType.H2).build();

	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("h2");
		return emf;
	}

}
