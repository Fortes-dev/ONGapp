package ongapp.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ongapp.dao.Usuario;

/**
 * @author carlos.fortes.medina && marco.testa.moreno
 *	Manager de la tabla Usuario
 */
public class UsuarioManager {
	
	/**
	 * @param con Conexion db
	 * @return Todos los usuarios
	 */
	public List<Usuario> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM usuario");
			result.beforeFirst();

			List<Usuario> usuarios = new ArrayList<>();

			while (result.next()) {
				usuarios.add(new Usuario(result));
			}
			con.close();
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	/**
	 * @param con Conexion db
	 * @param username nombre usuario
	 * @return Nos devuelve el username
	 */
	public String findLoginUser(Connection con, String username) {
		try (PreparedStatement prepStmt = con.prepareStatement("select username from usuario where username = ?")) {

			prepStmt.setString(1, username);

			ResultSet result = prepStmt.executeQuery();
			result.next();
			return result.getString("username");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @param con Conexion db
	 * @param username nombre usuario
	 * @return Nos devuelve un usuario para confirmar login
	 */
	public String findLoginRol(Connection con, String username) {
		try (PreparedStatement prepStmt = con.prepareStatement("select rol from usuario where username = ?")) {

			prepStmt.setString(1, username);

			ResultSet result = prepStmt.executeQuery();
			result.next();
			return result.getString("username");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param con Conexion db
	 * @param password contraseņa usuario
	 * @return Nos devuelve la password
	 */
	public String findLoginPassword(Connection con, String password) {
		try (PreparedStatement prepStmt = con.prepareStatement("select contraseņa from usuario where contraseņa = ?")) {

			prepStmt.setString(1, password);

			ResultSet result = prepStmt.executeQuery();
			result.next();
			return result.getString("contraseņa");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @param con Conexion db
	 * @param email email usuario
	 * @param username nombre usuario
	 * @param password contraseņa usuario
	 * @return Crea un nuevo usuario
	 */
	public void createUsuario(Connection con, String email, String username, String password) {

		try (PreparedStatement prepStmt = con.prepareStatement("INSERT INTO usuario (email, username, contraseņa, rol) VALUES (?, ?, ?, ?)")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, email);
			prepStmt.setString(2, username);
			prepStmt.setString(3, password);
			prepStmt.setString(4, "user");

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
	 * @param con Conexion db
	 * @param email email usuario
	 * @param username nombre usuario
	 * @param password contraseņa usuario
	 * @param rol rol usuario
	 * @return Crea un nuevo usuario de modo administrador
	 */
	public void createUsuarioAdmin(Connection con, String email, String username, String password, String rol) {

		try (PreparedStatement prepStmt = con.prepareStatement("INSERT INTO usuario (email, username, contraseņa, rol) VALUES (?, ?, ?, ?)")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, email);
			prepStmt.setString(2, username);
			prepStmt.setString(3, password);
			prepStmt.setString(4, rol);

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
	 * @param con Conexion db
	 * @param username nombre usuario
	 * @return Borra un registro de usuario(buscamos por nombre)
	 */
	public void deleteUsuario(Connection con, String username) {
		try (PreparedStatement prepStmt = con
				.prepareStatement("DELETE FROM usuario WHERE username = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, username);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
