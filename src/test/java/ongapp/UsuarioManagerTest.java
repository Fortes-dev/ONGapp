package ongapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import ongapp.conector.Conector;
import ongapp.dao.Usuario;
import ongapp.manager.UsuarioManager;


@RunWith(JUnitPlatform.class)
class UsuarioManagerTest {
	
	private Connection con;
	
	@BeforeEach
	void setUp() throws SQLException, ClassNotFoundException {
		con = new Conector().getMySQLConnection();
		con.createStatement().execute("use ongapp");
		con.createStatement().execute("INSERT INTO `ongapp`.`usuario` (`id`, `email`, `username`, `contraseña`, `rol`) "
				+ "VALUES ('132', 'prueba@gmail.com', 'prueba', 'prueba', 'admin')");
	}
	
	@Test
	void findAll_ok() throws SQLException {
		List<Usuario> usuarios = new UsuarioManager().findAll(con);
		assertTrue(usuarios.size()>0);
		assertFalse(usuarios.isEmpty());
	}
	
	@Test
	void findLoginUser_ok() throws SQLException {
		String user =  new UsuarioManager().findLoginUser(con, "prueba");
		assertEquals("prueba", user);
		assertFalse(user.isEmpty());
	}
	
	@Test
	void findLoginPassword_ok() throws SQLException {
		String user =  new UsuarioManager().findLoginPassword(con, "prueba");
		assertEquals("prueba", user);
		assertFalse(user.isEmpty());
	}
	
	@Test
	void findLoginRol_ok() throws SQLException {
		String user =  new UsuarioManager().findLoginRol(con, "prueba");
		assertEquals("admin", user);
		assertFalse(user.isEmpty());
	}
	
	@AfterEach
	void tearDown() throws SQLException {
		con.createStatement().execute("DELETE FROM usuario WHERE username = 'prueba'");
		con.close();
	}

}
