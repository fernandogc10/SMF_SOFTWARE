package dominio.controller;

import static org.junit.Assert.*;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;
import persistencia.AgenteBD;

public class GestorRepartoVacunasTest {

	private AgenteBD agenteBD;
	private Vector <Object> vector;



	@Before
	public void setUp() throws Exception {
		agenteBD = new AgenteBD();
		vector = new Vector <> ();

		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAltaNuevoLoteVacunas() throws Exception {
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		GestorRepartoVacunas.altaNuevoLoteVacunas(sqlDate, "covid", 100);
		
		this.vector = this.agenteBD.select("Select * from LoteVacunas where id= '"+ "'");
		
		
		
	}
	

	@Test
	public void testCalcularEntregasRegion() {
		

	}


}
