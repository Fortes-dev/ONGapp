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
	
	public void createUsuario(Connection con, int id, String nombre, String apellido, 
			String email, String username, String contraseña, int idLocalizacion) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?)")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, nombre);
			prepStmt.setString(3, apellido);
			prepStmt.setString(4, email);
			prepStmt.setString(5, username);
			prepStmt.setString(6, contraseña);
			prepStmt.setInt(7, idLocalizacion);

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
	
	public void modifyUsuario(Connection con, int id, String nuevoNombre, String apellido, String nombre,
			String email, String contraseña, int idLocalizacion) {

		try (PreparedStatement prepStmt = con
				.prepareStatement("UPDATE usuario SET nombre = ?, apellido = ?, email = ?, contraseña = ? WHERE id like ? OR nombre like ?")) {
			con.setAutoCommit(false);
			
			prepStmt.setString(1, nuevoNombre);
			prepStmt.setString(2, apellido);
			prepStmt.setString(3, email);
			prepStmt.setString(4, contraseña);
			prepStmt.setInt(5, id);
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
	
	public void deleteUsuario(Connection con, int id, String nombre) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM usuario WHERE id like ? or nombre like ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, nombre);
			prepStmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
}
