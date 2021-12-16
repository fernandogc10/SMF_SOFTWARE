package dominio.controller;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistencia.AgenteBD;

public class GestorVacunacionTest {
	
	AgenteBD agenteBD;

	@Before
	public void setUp() throws Exception {
		
		agenteBD = new AgenteBD ();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAltaEntregaVacunas() throws SQLException, Exception {
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		GestorVacunacion.altaEntregaVacunas("lote_0", sqlDate, 100, 1, "MADRID");
		
		Vector <Object> vector_comprobacion = new Vector <> ();
		
		vector_comprobacion = 
				this.agenteBD.select("Select * from Entregas where loteVacunas= 'lote_0'");
		
		System.out.println(vector_comprobacion.get(2));
		
		assertEquals("lote_0", vector_comprobacion.get(2));
	}

	@Test
	public void testRegistrarVacunacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeleccionarPrioridad() {
		fail("Not yet implemented");
	}

}
