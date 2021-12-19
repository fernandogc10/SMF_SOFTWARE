package persistencia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.Paciente;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.TipoVacuna;
import dominio.entitymodel.Vacunacion;

public class VacunacionDAOTest {
	
	java.sql.Date sqlDate;
	java.util.Date date;
	Vector<Object> vector = new Vector<>();
	AgenteBD agente;
	RegionEnum region = RegionEnum.MADRID;
	static List<Vacunacion> listaVacunados = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		
		date = new java.util.Date();
		sqlDate = new java.sql.Date(date.getTime());
		agente = new AgenteBD();
		
		

		Vacunacion vacunacion = new Vacunacion(sqlDate, false);

		Paciente paciente = new Paciente("03962854T", "Fernando", "Guerrero Cano");

		vacunacion.set_Paciente(paciente);
		vacunacion.get_paciente().set_Region(region);

		TipoVacuna tipovacuna = new TipoVacuna("covid", "PFIZER", sqlDate.toString());

		vacunacion.set_TipoVacuna(tipovacuna);
		

		VacunacionDAO.insertarVacunacion(vacunacion);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertarVacunacion() throws Exception {
		
		vector = AgenteBD.getAgente().select("Select dni_paciente from Vacunacion");
		
		assertEquals("03962854T", vector.get(0).toString());

	}

	@Test
	public void testSeleccionarVacunaciones() throws Exception {	
		
		listaVacunados = VacunacionDAO.seleccionarVacunaciones();
		
		assertEquals(1, listaVacunados.size());
	}

	@Test
	public void testSeleccionarVacunacionesRegionEnum() throws Exception {
		
		
		listaVacunados = VacunacionDAO.seleccionarVacunaciones(region);
		
		
		assertEquals(1, listaVacunados.size());
		
	}

	@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidas() {
		
	}

}
