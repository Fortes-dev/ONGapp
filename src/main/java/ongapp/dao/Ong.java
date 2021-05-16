package ongapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ong {
	int id;
	String nombre;
	String tipo;
	String web;
	String ciudad;
	String calle;

	public Ong(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.nombre = result.getString("nombre");
			this.tipo = result.getString("tipo");
			this.web = result.getString("web");
			this.ciudad = result.getString("ciudad");
			this.calle = result.getString("calle");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
