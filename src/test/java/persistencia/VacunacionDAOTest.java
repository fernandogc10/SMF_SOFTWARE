package persistencia;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.controller.GestorEstadisticas;
import dominio.entitymodel.Paciente;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.TipoVacuna;
import dominio.entitymodel.Vacunacion;

public class VacunacionDAOTest {
	
	java.sql.Date sqlDate;
	java.util.Date date;
	Vector<Object> vector = new Vector<>();

	static List<Vacunacion> listaVacunados = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		
		date = new java.util.Date();
		sqlDate = new java.sql.Date(date.getTime());
	}


	@Test(expected = Exception.class)
	public void testInsertarVacunacion1() throws Exception {
		

		Vacunacion vacunacion = new Vacunacion(null, true);

		Paciente paciente = new Paciente("03962854T", "Fernando", "Guerrero Cano");

		vacunacion.set_Paciente(paciente);
		vacunacion.get_paciente().set_Region(RegionEnum.MADRID);

		TipoVacuna tipovacuna = new TipoVacuna("covid", "PFIZER", sqlDate.toString());

		vacunacion.set_TipoVacuna(tipovacuna);
		

		VacunacionDAO.insertarVacunacion(vacunacion);
		
		
		

	}
	
	
	@Test(expected = Exception.class)
	public void testInsertarVacunacion2() throws Exception {
		

		Vacunacion vacunacion = new Vacunacion(this.sqlDate, false);

		Paciente paciente = new Paciente("03719854Y", "Marcelino", "Diaz Alba");

		vacunacion.set_Paciente(paciente);
		vacunacion.get_paciente().set_Region(RegionEnum.VALENCIA);

		TipoVacuna tipovacuna = new TipoVacuna(null, "PFIZER", sqlDate.toString());

		vacunacion.set_TipoVacuna(tipovacuna);
		
		
		

		VacunacionDAO.insertarVacunacion(vacunacion);
		

	}
	
	@Test
	public void testInsertarVacunacion3() throws Exception {
		

		Vacunacion vacunacion = new Vacunacion(this.sqlDate, true);

		Paciente paciente = new Paciente("03997124P", "Sergio", "Diaz de la Peña");

		vacunacion.set_Paciente(paciente);
		vacunacion.get_paciente().set_Region(RegionEnum.NAVARRA);

		TipoVacuna tipovacuna = new TipoVacuna("covid", "PFIZER", sqlDate.toString());

		vacunacion.set_TipoVacuna(tipovacuna);
		

		VacunacionDAO.insertarVacunacion(vacunacion);
		
		vector = AgenteBD.getAgente().select("Select dni_paciente from Vacunacion where dni_paciente= "
				+ " '03997124P'");
		
		assertEquals("03997124P", vector.get(0).toString());
		
		

	}
	
	@Test(expected = Exception.class)
	public void testInsertarVacunacion4() throws Exception {
		

		Vacunacion vacunacion = new Vacunacion(this.sqlDate, false);

		Paciente paciente = new Paciente(null, null, null);

		vacunacion.set_Paciente(paciente);
		vacunacion.get_paciente().set_Region(null);

		TipoVacuna tipovacuna = new TipoVacuna("covid", "PFIZER", sqlDate.toString());

		vacunacion.set_TipoVacuna(tipovacuna);
		

		VacunacionDAO.insertarVacunacion(vacunacion);
		

	}
	

	@Test
	public void testSeleccionarVacunaciones() throws Exception {	
		
		Vacunacion vacunacion = new Vacunacion(this.sqlDate, false);

		Paciente paciente = new Paciente("03997124P", "Sergio", "Diaz de la Peña");

		vacunacion.set_Paciente(paciente);
		vacunacion.get_paciente().set_Region(RegionEnum.NAVARRA);

		TipoVacuna tipovacuna = new TipoVacuna("covid", "PFIZER", sqlDate.toString());

		vacunacion.set_TipoVacuna(tipovacuna);
		

		VacunacionDAO.insertarVacunacion(vacunacion);
		
		listaVacunados = VacunacionDAO.seleccionarVacunaciones();
		
		assertEquals(1, listaVacunados.size());
	}

	@Test(expected = Exception.class)
	public void testSeleccionarVacunacionesRegionEnum1() throws SQLException, Exception{
		
		
		listaVacunados = VacunacionDAO.seleccionarVacunaciones(null);
		
		
	}
	
	@Test
	public void testSeleccionarVacunacionesRegionEnum2() throws SQLException, Exception{
		
		
		listaVacunados = VacunacionDAO.seleccionarVacunaciones(RegionEnum.MADRID);
		
		
		assertEquals(1, listaVacunados.size());
		
	}
	
	@Test
	public void testSeleccionarVacunacionesRegionEnum3() throws SQLException, Exception{
		
		
		listaVacunados = VacunacionDAO.seleccionarVacunaciones(RegionEnum.CATALUÑA);
		
		
		assertEquals(1, listaVacunados.size());
		
	}
	
	
	@Test
	public void testSeleccionarVacunacionesRegionEnum4() throws SQLException, Exception{
		
		
		listaVacunados = VacunacionDAO.seleccionarVacunaciones(RegionEnum.ANDALUCÍA);
		
		
		assertEquals(1, listaVacunados.size());
		
	}

	@Test(expected = Exception.class)
	public void testConsultarPorcentajeVacunadosSobreRecibidasEnRegion1() throws SQLException, Exception {
		
		GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidasEnRegion(null);
		
		
		
	}
	
	/*@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidasEnRegion2() throws SQLException, Exception {
		
		GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum.MADRID);
		
		
		
	}
	
	@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidasEnRegion3() throws SQLException, Exception {
		
		GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum.CATALUÑA);
		
		
		
	}
	
	@Test
	public void testConsultarPorcentajeVacunadosSobreRecibidasEnRegion4() throws SQLException, Exception {
		
		GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum.ANDALUCÍA);
		
		
		
	}*/

}
