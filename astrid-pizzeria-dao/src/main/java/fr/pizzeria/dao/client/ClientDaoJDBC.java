package fr.pizzeria.dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.pizzeria.dao.other.JDBCDao;
import fr.pizzeria.model.Client;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class ClientDaoJDBC implements ClientDao {
	private JDBCDao jdbcDao;

	public ClientDaoJDBC(JDBCDao jdbcDao) {
		this.jdbcDao = jdbcDao;
	}

	@Override
	public void saveNewClient(Client client) {
		jdbcDao.execute((Connection connection, Statement statement) -> {
			PreparedStatement addClient = connection
					.prepareStatement("INSERT INTO client ( nom,prenom,email,motDePasse ) VALUES (?,?,?,?)");
			addClient.setString(1, client.getNom());
			addClient.setString(2, client.getPrenom());
			addClient.setString(3, client.getEmail());
			addClient.setString(4, client.getMotDePasse());
			addClient.executeUpdate();
			return Void.TYPE;
		});
	}

	@Override
	public Client connectNewClient(Client client) {
		return jdbcDao.execute((Connection connection, Statement statement) -> {
			PreparedStatement selClient = connection
					.prepareStatement("SELECT * FROM client WHERE email = ? AND motDePasse= ?");
			selClient.setString(1, client.getEmail());
			selClient.setString(2, client.getMotDePasse());
			ResultSet rs = selClient.executeQuery();
			if (rs.getString("email").equals(client.getEmail())
					&& rs.getString("motDePasse").equals(client.getMotDePasse())) {
				return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
						rs.getString("motDePasse"));
			} else {
				return null;
			}
		});
	}

	@Override
	public void close() {

	}

}
