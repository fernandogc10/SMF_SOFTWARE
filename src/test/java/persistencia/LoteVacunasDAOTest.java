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

	@Test(expected = Exception.class)
	public void testInsertarLoteVacunas1() throws Exception {

		Vector<Object> vector = new Vector<>();

		LoteVacunas lote = new LoteVacunas(null, null, "Covid-19", -35);

		LoteVacunasDAO.insertarLoteVacunas(lote);

	}

	@Test(expected = Exception.class)
	public void testInsertarLoteVacunas2() throws Exception {

		Vector<Object> vector = new Vector<>();

		LoteVacunas lote = new LoteVacunas("lote_1", this.sqlDate, "Covid-19", 0);

		LoteVacunasDAO.insertarLoteVacunas(lote);

	}

	@Test
	public void testInsertarLoteVacunas3() throws Exception {

		Vector<Object> vector = new Vector<>();

		LoteVacunas lote = new LoteVacunas("lote_20", this.sqlDate, "Covid-19", 60);

		LoteVacunasDAO.insertarLoteVacunas(lote);

		vector = AgenteBD.select("Select id from lotevacunas where id= 'lote_20'");

		assertEquals("lote_20", vector.get(0).toString());

	}

	@Test
	public void testInsertarLoteVacunas4() throws Exception {

		Vector<Object> vector = new Vector<>();

		LoteVacunas lote = new LoteVacunas("lote_20", this.sqlDate, "Covid-19", 60);

		LoteVacunasDAO.insertarLoteVacunas(lote);

		vector = AgenteBD.select("Select id from lotevacunas where id= 'lote_20'");

		assertEquals("lote_20", vector.get(0).toString());

	}

	@Test(expected = Exception.class)
	public void testInsertarLoteVacunas5() throws Exception {

		Vector<Object> vector = new Vector<>();

		LoteVacunas lote = new LoteVacunas("lote_1", this.sqlDate, "Covid-19", 0);

		LoteVacunasDAO.insertarLoteVacunas(lote);

	}

}
