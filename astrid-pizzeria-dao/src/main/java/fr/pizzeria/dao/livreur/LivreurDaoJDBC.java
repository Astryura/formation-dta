package fr.pizzeria.dao.livreur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import fr.pizzeria.dao.other.JDBCDao;
import fr.pizzeria.model.Livreur;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class LivreurDaoJDBC implements LivreurDao {

	/**
	 * @see JDBCDao#JDBCDao()
	 */

	private JDBCDao jdbcDao;

	/**
	 * Constructeur
	 * 
	 * @param jdbcDao
	 */
	public LivreurDaoJDBC(JDBCDao jdbcDao) {
		this.jdbcDao = jdbcDao;
	}

	@Override
	public void addLivreur(Livreur livreur) {
		jdbcDao.execute((Connection connection, Statement statement) -> {
			PreparedStatement addLivreur = connection
					.prepareStatement("INSERT INTO livreur ( nom,prenom ) VALUES (?,?)");
			addLivreur.setString(1, livreur.getNom());
			addLivreur.setString(2, livreur.getPrenom());
			addLivreur.executeUpdate();
			return Void.TYPE;
		});

	}

	@Override
	public void close() {
		// connection est auto-close
	}

}
