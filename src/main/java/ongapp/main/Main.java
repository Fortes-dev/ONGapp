package ongapp.main;

import java.sql.Connection;
import java.sql.SQLException;

import ongapp.conector.Conector;
import ongapp.manager.UsuarioManager;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		


	}
}