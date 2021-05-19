package ongapp;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ongapp.conector.Conector;
import ongapp.dao.Ong;

import ongapp.manager.OngManager;

class OngManagerTest {

	private Connection con;

	@BeforeEach
	void setUp() throws Exception {
		con = new Conector().getMySQLConnection();
		con.createStatement().execute("use ongapp");
		con.createStatement().execute("INSERT INTO `ongapp`.`ong` (`id`, `nombre`, `tipo`, `web`, `ciudad`, `calle`) "
				+ "VALUES ('20', 'Hospital PRUEBA', 'Health', 'PRUEBA.ES', 'Málaga', 'C/ Prueba');");
	}

	@Test
	void testFindAll() {
		List<Ong> ongAll = new OngManager().findAll(con);
		assertTrue(ongAll.size()>0);
		assertFalse(ongAll.isEmpty());
	}
	
	@Test
	void testFindByNombre() {
		List<Ong> ongNombre = new OngManager().findAll(con);
		assertTrue(ongNombre.size()>0);
		assertFalse(ongNombre.isEmpty());
	}

	@Test
	void testFindByCiudad() {
		List<Ong> ongCiudad = new OngManager().findAll(con);
		assertTrue(ongCiudad.size()>0);
		assertFalse(ongCiudad.isEmpty());
	}

	@Test
	void testFindByTipo() {
		List<Ong> ongTipo = new OngManager().findAll(con);
		assertTrue(ongTipo.size()>0);
		assertFalse(ongTipo.isEmpty());
	}
	
	@AfterEach
	void tearDown() throws Exception {
		con.createStatement().execute("DELETE FROM ong WHERE web='PRUEBA.ES'");
		con.close();
	}
	
}
