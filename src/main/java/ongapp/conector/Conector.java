package ongapp.conector;

import java.io.IOException;
import lombok.Getter;
import lombok.Setter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Conector {
	@Setter
	@Getter
	Properties prop = new Properties();

	public Conector() {
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Connection getMySQLConnection()throws ClassNotFoundException, SQLException {
		try {

			// Indicates which driver is going to be used.
			Class.forName(prop.getProperty(MySQLConstants.DRIVER));

			try {
				// Creates the connection based on the obtained URL.
				return DriverManager.getConnection(getURL());
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String getURL() {
		return new StringBuilder().append(prop.getProperty(MySQLConstants.URL_PREFIX))
		.append(prop.getProperty(MySQLConstants.URL_HOST)).append(":")
		.append(prop.getProperty(MySQLConstants.URL_PORT)).append("/")
		.append(prop.getProperty(MySQLConstants.URL_SCHEMA)).append("?user=")
		.append(prop.getProperty(MySQLConstants.USER)).append("&password=")
		.append(prop.getProperty(MySQLConstants.PASSWD)).append("&useSSL=")
		.append(prop.getProperty(MySQLConstants.URL_SSL)).toString();
		}
	// --- jdbc:mysql://localhost:3307/ongapp?user=sa&password=root&userSSL=false
}