package dominio.controller;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.Vacunacion;

public class GestorEstadisticasTest {
	
	List<Vacunacion> listaVacunados;
	RegionEnum region;

	/*@Before
	public void setUp() throws Exception {
		listaVacunados = new ArrayList<>();
		
		GestorVacunacion.registrarVacunacion(sqlDate, null, null, null, null);
		
		region =GestorVacunacion.get;
	}*/

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConsultarTotalVacunados() {
		
	}

	@Test
	public void testConsultarTotalVacunadosPorRegion() throws SQLException, Exception {
		
		
		
	
	}

	@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidas() {
	}

	@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidasEnRegion() {
	}

}
