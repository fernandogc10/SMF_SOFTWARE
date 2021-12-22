package persistencia;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;
import dominio.controller.*;
import dominio.entitymodel.RegionEnum;

public class EntregaDAOTest {

	java.util.Date date;
	java.sql.Date sqlDate;
	Vector<Object> vector = new Vector<>();
	List<EntregaVacunas> listaEntregaVacunas = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		this.date = new java.util.Date();
		this.sqlDate = new java.sql.Date(date.getTime());
	}

	@Test(expected = Exception.class)
	public void testInsertarEntrega1() throws Exception {

		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(null, -30);

		nuevaEntrega.set_grupoPrioridad(GestorVacunacion.seleccionarPrioridad(-10));

		LoteVacunas lote = new LoteVacunas("lote_1", sqlDate, "covid", 100);

		nuevaEntrega.setLoteVacunas(lote);

		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion("Madrid");

		EntregaDAO.insertarEntrega(nuevaEntrega);

	}

	@Test(expected = Exception.class)
	public void testInsertarEntrega2() throws Exception {

		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(this.sqlDate, 0);

		nuevaEntrega.set_grupoPrioridad(GestorVacunacion.seleccionarPrioridad(0));

		LoteVacunas lote = new LoteVacunas(null, sqlDate, "covid", 100);

		nuevaEntrega.setLoteVacunas(lote);

		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion("Valencia");

		EntregaDAO.insertarEntrega(nuevaEntrega);

	}

	@Test
	public void testInsertarEntrega3() throws Exception {

		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(this.sqlDate, 50);

		nuevaEntrega.set_grupoPrioridad(GestorVacunacion.seleccionarPrioridad(1));

		LoteVacunas lote = new LoteVacunas("lote_1", sqlDate, "covid", 100);

		nuevaEntrega.setLoteVacunas(lote);

		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion("Navarra");

		EntregaDAO.insertarEntrega(nuevaEntrega);
		
		System.out.println(nuevaEntrega.get_lote().get_id());

		vector = AgenteBD.getAgente().select("Select loteVacunas from Entregas" +
		" where loteVacunas= '" + nuevaEntrega.get_lote().get_id() + "'");
		
		System.out.println(vector.size());
		
		assertEquals("lote_1", vector.get(0).toString());

	}

	@Test(expected = Exception.class)
	public void testInsertarEntrega4() throws Exception {

		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(this.sqlDate, -30);

		nuevaEntrega.set_grupoPrioridad(GestorVacunacion.seleccionarPrioridad(2));

		LoteVacunas lote = new LoteVacunas("lote_3", sqlDate, "covid", 100);

		nuevaEntrega.setLoteVacunas(lote);

		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion(null);

		EntregaDAO.insertarEntrega(nuevaEntrega);

	}

	@Test(expected = Exception.class)
	public void testInsertarEntrega5() throws Exception {

		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(this.sqlDate, 0);

		nuevaEntrega.set_grupoPrioridad(GestorVacunacion.seleccionarPrioridad(3));

		LoteVacunas lote = new LoteVacunas("lote_5", sqlDate, "covid", 100);

		nuevaEntrega.setLoteVacunas(lote);

		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion("Madrid");

		EntregaDAO.insertarEntrega(nuevaEntrega);

	}

	@Test(expected = Exception.class)
	public void testInsertarEntrega6() throws Exception {

		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(this.sqlDate, 50);

		nuevaEntrega.set_grupoPrioridad(GestorVacunacion.seleccionarPrioridad(40));

		LoteVacunas lote = new LoteVacunas(null, sqlDate, "covid", 100);

		nuevaEntrega.setLoteVacunas(lote);

		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion("Valencia");

		EntregaDAO.insertarEntrega(nuevaEntrega);

	}

	@Test
	public void testSeleccionarEntregas() throws Exception {

		vector = AgenteBD.getAgente().select("Select region from Entregas");

		listaEntregaVacunas = EntregaDAO.seleccionarEntregas();

	}

}
