package persistencia;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntregaDAOTest {

	java.util.Date date;
	java.sql.Date sqlDate;
	@Before
	public void setUp() throws Exception {
		AgenteBD agentebd = new AgenteBD ();
		date = new java.util.Date();
		sqlDate = new java.sql.Date(date.getTime());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntregaDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarEntrega() throws Exception {
		
		Vector <Object> vector = new Vector <> ();
		
		
		
		EntregaDAO.insertarEntrega("Insert into Entregas "
				+ "(fecha, cantidad, loteVacunas, region, tipoVacuna, GrupoPrioridad) values ("
				+ "'"+ (this.sqlDate).toString() + "', 1000, 'lote_1', 'Madrid', 'Covid-19', 1");
		
		
		vector = AgenteBD.select("Select * from Entregas where loteVacunas= 'lote_1'");
		
		
		
		for (int i = 0; i<vector.size(); i++) {
			System.out.println(vector.get(i).toString());
		}
		
		//assertEquals("lote_1", vector.get(0).toString());
		
		
	}

	@Test
	public void testSeleccionarEntregas() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgenteBD() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAgente() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelect() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrearBaseDatosSinoExiste() {
		fail("Not yet implemented");
	}

}
