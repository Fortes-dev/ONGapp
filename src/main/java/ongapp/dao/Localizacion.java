package ongapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Localizacion {
	int id;
	String comunidadAutonoma;
	String provincia;
	String ciudad;
	String calle;
	String latitud;
	String longitud;
	
	public Localizacion(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.comunidadAutonoma = result.getString("comunidadautonoma");
			this.provincia = result.getString("provincia");
			this.ciudad = result.getString("ciudad");
			this.calle = result.getString("calle");
			this.latitud = result.getString("latidud");
			this.longitud = result.getString("latitud");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
