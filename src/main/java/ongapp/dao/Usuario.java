package ongapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
	int id;
	String email;
	String username;
	String contrase�a;
	String rol;

	public Usuario(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.email = result.getString("email");
			this.username = result.getString("username");
			this.contrase�a = result.getString("contrase�a");
			this.rol = result.getString("rol");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
