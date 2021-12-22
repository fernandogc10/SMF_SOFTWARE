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

	private Vector<Object> vector_comprobacion;
	java.util.Date date;
	java.sql.Date sqlDate;

	@Before
	public void setUp() throws Exception {
		Vector<Object> vector_comprobacion = new Vector<>();
		date = new java.util.Date();
		sqlDate = new java.sql.Date(date.getTime());
	}



	@Test(expected = Exception.class)
	public void testAltaNuevoLoteVacunas1() throws Exception {
		
		
		GestorRepartoVacunas.altaNuevoLoteVacunas(null, "covid", -30);
		
		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from "
				+ "LoteVacunas where fecha= '"+this.sqlDate+  "'");

		
	}
	
	@Test(expected = Exception.class)
	public void testAltaNuevoLoteVacunas2() throws Exception {
		
		
		GestorRepartoVacunas.altaNuevoLoteVacunas(this.sqlDate, null, 0);
		
		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from "
				+ "LoteVacunas where fecha= '"+this.sqlDate+  "'");

		
	}
	
	@Test
	public void testAltaNuevoLoteVacunas3() throws Exception {
		
		
		GestorRepartoVacunas.altaNuevoLoteVacunas(this.sqlDate, "covid", 5);
		
		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from "
				+ "LoteVacunas where fecha= '"+this.sqlDate+  "'");
		
		assertEquals(this.sqlDate.toString(),  this.vector_comprobacion.get(1).toString());

		
	}
	
	@Test(expected = Exception.class)
	public void testAltaNuevoLoteVacunas4() throws Exception {
		
		
		GestorRepartoVacunas.altaNuevoLoteVacunas(this.sqlDate, null, 1000);
		
		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from "
				+ "LoteVacunas where fecha= '"+this.sqlDate+  "'");

		
	}
	

	/*@Test
	public void testCalcularEntregasRegion() {
		

	}*/


}
