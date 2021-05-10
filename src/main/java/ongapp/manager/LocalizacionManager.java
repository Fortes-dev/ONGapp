package ongapp.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ongapp.dao.Localizacion;

public class LocalizacionManager {
	
	public List<Localizacion> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM localizacion");
			result.beforeFirst();

			List<Localizacion> local = new ArrayList<>();

			while (result.next()) {
				local.add(new Localizacion(result));
			}
			con.close();
			return local;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
