package ongapp.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ongapp.dao.Ong;


public class OngManager {
	
	public List<Ong> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM ong o JOIN localizacion l on (o.localizacionid = l.id)");
			result.beforeFirst();

			List<Ong> ong = new ArrayList<>();

			while (result.next()) {
				ong.add(new Ong(result));
			}
			con.close();
			return ong;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	//Localiza las ong por localizacion(distancia del usuario)
	public void findByIdLocalizacion(Connection con, int idLocalizacion) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("SELECT * FROM ong o RIGHT JOIN localizacion l on (o.localizacionid = l.id) where idlocalizacion like ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, idLocalizacion);
			prepStmt.executeUpdate();

			con.commit();
			con.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}
