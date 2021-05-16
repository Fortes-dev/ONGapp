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

	/**
	 * @return Devuelve lista de todas las ongs
	 */
	public List<Ong> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt
					.executeQuery("SELECT * FROM ong");
			result.beforeFirst();

			List<Ong> ong = new ArrayList<>();

			while (result.next()) {
				ong.add(new Ong(result));
			}
			return ong;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	/**
	 * @return Devuelve las ong dado el nombre en el argumento 
	 */
	public List<Ong> findByNombre(Connection con, String nombre) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM ong WHERE nombre LIKE %?%")) {
			prepStmt.setString(1, nombre);
			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();
			List<Ong> ong = new ArrayList<>();

			while (result.next()) {
				ong.add(new Ong(result));
			}
			return ong;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * @return Devuelve las ong dada la ciudad del argumento
	 */
	public List<Ong> findByCiudad(Connection con, String ciudad) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM ong WHERE ciudad LIKE %?%")) {
			prepStmt.setString(1, ciudad);
			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();
			List<Ong> ong = new ArrayList<>();

			while (result.next()) {
				ong.add(new Ong(result));
			}
			return ong;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public List<Ong> findByTipo(Connection con, String tipo) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM ong WHERE tipo LIKE %?%")) {
			prepStmt.setString(1, tipo);
			ResultSet result = prepStmt.executeQuery();
			result.beforeFirst();
			List<Ong> ong = new ArrayList<>();

			while (result.next()) {
				ong.add(new Ong(result));
			}
			return ong;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
