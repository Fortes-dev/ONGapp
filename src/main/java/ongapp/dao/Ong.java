package ongapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/**
 * DAO de ONG
 * @author carlos.fortes.medina && marco.testa.moreno
 *
 */
public class Ong {
	/**
	 * Elementos de la tabla ong en la base de datos
	 */
	private	int id;
	private String nombre;
	private String tipo;
	private String web;
	private String ciudad;
	private String calle;
	
	/**
	 * Constructor del dao
	 * @param result Entrada de tipo ResultSet
	 */
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
