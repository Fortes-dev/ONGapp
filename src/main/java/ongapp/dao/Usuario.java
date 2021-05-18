package ongapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
/**
 * DAO de usuario
 * @author carlos.fortes.medina
 *
 */
public class Usuario {
	/**
	 * Elementos de la tabla usuario
	 */
	int id;
	String email;
	String username;
	String contrase�a;
	String rol;
	
	/**
	 * Constructor del dao
	 * @param result Entrada de tipo ResultSet
	 */
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
