package dominio.controller;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.TipoVacuna;
import persistencia.AgenteBD;

public class GestorVacunacionTest {
	
	AgenteBD agenteBD;
	Vector <Object> vector_comprobacion;
	java.util.Date date;
	java.sql.Date sqlDate;

	@Before
	public void setUp() throws Exception {
		
		agenteBD = new AgenteBD ();
		vector_comprobacion = new Vector <> ();
		date = new java.util.Date();
		sqlDate = new java.sql.Date(date.getTime());
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAltaEntregaVacunas() throws SQLException, Exception {
		
		
		
		GestorVacunacion.altaEntregaVacunas("lote_0", this.sqlDate, 100, 1, "MADRID");
		
		
		this.vector_comprobacion = 
				this.agenteBD.select("Select * from Entregas where loteVacunas= 'lote_0'");
		
		System.out.println(vector_comprobacion.get(2));
		
		assertEquals("lote_0", this.vector_comprobacion.get(2));
	}

	@Test
	public void testRegistrarVacunacion() throws Exception {
		
		TipoVacuna tipo = new TipoVacuna("covid", "PFIZER", this.sqlDate.toString());
		
		GestorVacunacion.registrarVacunacion(this.sqlDate, "Fernando",
				"Guerrero Cano", "03962854T", tipo);
		
		this.vector_comprobacion = 
				AgenteBD.select("Select * from Vacunacion where dni_paciente= '03962854T'");
		
		assertEquals("03962854T", this.vector_comprobacion.get(2).toString());
	}

	@Test
	public void testSeleccionarPrioridad() {
		

	}

}
