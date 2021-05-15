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

public class UsuarioManager {
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

	public String findLoginPassword(Connection con, String password) {
		try (PreparedStatement prepStmt = con.prepareStatement("select contraseña from usuario where contraseña = ?")) {

			prepStmt.setString(1, password);

			ResultSet result = prepStmt.executeQuery();
			result.next();
			return result.getString("contraseña");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void createUsuario(Connection con, String email, String username, String contraseña) {

		try (PreparedStatement prepStmt = con.prepareStatement("INSERT INTO usuario (email, username, contraseña) VALUES (?, ?, ?)")) {
			con.setAutoCommit(false);

			prepStmt.setString(1, email);
			prepStmt.setString(2, username);
			prepStmt.setString(3, contraseña);

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

	public void deleteUsuario(Connection con, int id, String username) {
		try (PreparedStatement prepStmt = con
				.prepareStatement("DELETE FROM usuario WHERE id like ? or username like ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, username);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
