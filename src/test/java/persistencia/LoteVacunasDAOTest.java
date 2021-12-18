package persistencia;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.LoteVacunas;

public class LoteVacunasDAOTest {
	
	java.util.Date date;
	java.sql.Date sqlDate;

	@Before
	public void setUp() throws Exception {
		
		date = new java.util.Date();
		sqlDate = new java.sql.Date(date.getTime());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoteVacunasDAO() {
	}

	@Test
	public void testInsertarLoteVacunas() throws Exception {
		
		Vector <Object> vector = new Vector <> ();
		
		LoteVacunas lote = new LoteVacunas("lote_0",this.sqlDate, "Covid-19", 1000);
		
		LoteVacunasDAO.insertarLoteVacunas(lote);
		
		vector = AgenteBD.select("Select * from lotevacunas where id= 'lote_0'" );
		
		assertEquals("lote_0", vector.get(0).toString());
		
		
		
	}

}
