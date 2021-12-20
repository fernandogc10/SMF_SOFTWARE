package dominio.entitymodel;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistencia.AgenteBD;

public class LoteVacunasTest {
	
	java.util.Date date;
	java.sql.Date sqlDate;
	
	Vector<Object> vector;
	
	AgenteBD agentebd;

	@Before
	public void setUp() throws Exception {
		
		date = new java.util.Date();
		sqlDate = new java.sql.Date(date.getTime());
		vector = new Vector<>();
		agentebd = new AgenteBD ();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoteVacunas() {
		
	}

	@Test
	public void testAltaNuevoLoteVacunas() throws Exception {
		
		LoteVacunas lote = new LoteVacunas("lote_prueba", sqlDate, "Covid-19", 1000);
		
		LoteVacunas.altaNuevoLoteVacunas(lote);
		
		vector = AgenteBD.getAgente().select("Select id from LoteVacunas where id= 'lote_prueba'");
		
		
		assertEquals("lote_prueba", vector.get(0).toString());
		
	}

	@Test
	public void testCalculoLotes() throws Exception{
		
		LoteVacunas lote = new LoteVacunas("lote_prueba", sqlDate, "Covid-19", 1000);
		
		
		LoteVacunas.listalotes.add(lote);
		
		
		assertEquals(1, LoteVacunas.calculoLotes());
	}



}
