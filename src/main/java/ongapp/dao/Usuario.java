package ongapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
	int id;
	String nombre;
	String apellido;
	String email;
	String username;
	String contrase�a;
	int idLocalizacion;

	public Usuario(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.nombre = result.getString("nombre");
			this.apellido = result.getString("apellido");
			this.email = result.getString("email");
			this.username = result.getString("username");
			this.contrase�a = result.getString("contrase�a");
			this.idLocalizacion = result.getInt("idlocalizacion");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}