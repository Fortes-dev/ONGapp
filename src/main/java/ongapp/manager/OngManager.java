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
/**
 * Manager de la tabla ONG en SQL
 * @author carlos.fortes.medina
 *
 */
public class OngManager {

	/**
	 * Busca todas las ongs
	 * @param con Conexion a SQL
	 * @return Lista de todas las ong
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
	 * Busca ongs por nombre
	 * @param con Conexion a SQL
	 * @param nombre entrada String nombre de ong
	 * @return Lista de todas las ong dependiendo de la entrada dada.
	 */
	public List<Ong> findByNombre(Connection con, String nombre) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM ong WHERE nombre LIKE ?")) {
			prepStmt.setString(1, "%"+nombre+"%");
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
	 * Busca ongs por ciudad
	 * @param con Conexion a SQL
	 * @param ciudad entrada String ciudad de ong
	 * @return Lista de todas las ong dependiendo de la entrada dada
	 */
	public List<Ong> findByCiudad(Connection con, String ciudad) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM ong WHERE ciudad LIKE ?")) {
			prepStmt.setString(1, "%"+ciudad+"%");
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
	 * Busca ongs por tipo
	 * @param con Conexion SQL
	 * @param tipo entrada String tipo de ong
	 * @return Lista de todas las ong por entrada dada
	 */
	public List<Ong> findByTipo(Connection con, String tipo) {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM ong WHERE tipo LIKE ?")) {
			prepStmt.setString(1, "%"+tipo+"%");
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
	 * Crea una nueva ong
	 * @param con Conexion SQL
	 * @param nombre Entrada de nombre de la ong
	 * @param tipo Entrada de tipo de la ong
	 * @param web Entrada de web de la ong
	 * @param ciudad Entrada de ciudad de la ong
	 * @param calle Entrada de calle de la ong
	 */
	public void createOng(Connection con, String nombre, String tipo, String web, String ciudad, String calle) {

		try (PreparedStatement prepStmt = con.prepareStatement("INSERT INTO ong (nombre, tipo, web, ciudad, calle) VALUES (?, ?, ?, ?, ?)")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, nombre);
			prepStmt.setString(2, tipo);
			prepStmt.setString(3, web);
			prepStmt.setString(4, ciudad);
			prepStmt.setString(5, calle);

			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	/**
	 * Modifica una ong
	 */
	public void modifyOng(Connection con, String newNombre, String tipo, String web, String ciudad, String calle, String nombre) {

		try (PreparedStatement prepStmt = con.prepareStatement("UPDATE ong SET nombre=?, tipo=?, web=?, ciudad=?, calle=? where nombre=?")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, newNombre);
			prepStmt.setString(2, tipo);
			prepStmt.setString(3, web);
			prepStmt.setString(4, ciudad);
			prepStmt.setString(5, calle);
			prepStmt.setString(6, nombre);

			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	
	/**
	 * Borra un registro de ong(buscamos por nombre)
	 */
	public void deleteOng(Connection con, String nombre) {
		try (PreparedStatement prepStmt = con
				.prepareStatement("DELETE FROM ong WHERE nombre = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, nombre);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
