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
	
	public boolean findLogin(Connection con, String username, String contraseña) {
		try (PreparedStatement prepStmt = con
				.prepareStatement("select username from login where username = ? and contraseña = ?")) {

			prepStmt.setString(1, username);
			prepStmt.setString(2, contraseña);

			ResultSet result = prepStmt.executeQuery();

			con.close();
			
			if (result.next())
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public void createUsuario(Connection con, String email, String username, String contraseña) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("INSERT INTO usuario VALUES (?, ?, ?)")) {
			con.setAutoCommit(false);
			
			prepStmt.setString(1, email);
			prepStmt.setString(2, username);
			prepStmt.setString(3, contraseña);

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
	
	
	public void deleteUsuario(Connection con, int id, String username) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM usuario WHERE id like ? or username like ?")) {
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
