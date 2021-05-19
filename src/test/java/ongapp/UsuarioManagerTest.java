package ongapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ongapp.conector.Conector;
import ongapp.dao.Usuario;
import ongapp.manager.UsuarioManager;

class UsuarioManagerTest {

	private Connection con;
	
	@BeforeEach
	void setUp() throws Exception {
		con = new Conector().getMySQLConnection();
		con.createStatement().execute("use ongapp");
	}
	
	@Test
	void findAll_ok() {
		List<Usuario> usuarios = new UsuarioManager().findAll(con);
		assertTrue(usuarios.size()>0);
		assertFalse(usuarios.isEmpty());
	}
	
	@Test
	void findLoginUser_ok() {
		String user =  new UsuarioManager().findLoginUser(con, "carlos");
		assertEquals("carlos", user);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		con.close();
	}

}
