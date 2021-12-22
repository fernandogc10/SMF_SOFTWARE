package dominio.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestorVacunacionTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testAltaEntregaVacunas() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistrarVacunacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeleccionarPrioridad() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
=======
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.entitymodel.GrupoPrioridad;
import dominio.entitymodel.TipoVacuna;
import persistencia.AgenteBD;

public class GestorVacunacionTest {

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
	public void testAltaEntregaVacunas1() throws SQLException, Exception {

		GestorVacunacion.altaEntregaVacunas(null, this.sqlDate, -20, -30, "MADRID");

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Entregas where loteVacunas= 'lote_0'");

		assertEquals("lote_0", this.vector_comprobacion.get(2));

	}

	@Test(expected = Exception.class)
	public void testAltaEntregaVacunas2() throws SQLException, Exception {

		GestorVacunacion.altaEntregaVacunas("lote_0", null, 1000, 0, "Valencia");

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Entregas where loteVacunas= 'lote_0'");

		assertEquals("lote_0", this.vector_comprobacion.get(2));

	}

	@Test(expected = Exception.class)
	public void testAltaEntregaVacunas3() throws SQLException, Exception {

		GestorVacunacion.altaEntregaVacunas("lote_5", this.sqlDate, 0, 1, "Navarra");

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Entregas where loteVacunas= 'lote_5'");

		assertEquals("lote_5", this.vector_comprobacion.get(2));

	}

	@Test
	public void testAltaEntregaVacunas4() throws SQLException, Exception {

		GestorVacunacion.altaEntregaVacunas("lote_0", this.sqlDate, 1000, 2, "Navarra");

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Entregas where loteVacunas= 'lote_0'");

		assertEquals("lote_0", this.vector_comprobacion.get(2));

	}

	@Test(expected = Exception.class)
	public void testAltaEntregaVacunas5() throws SQLException, Exception {

		GestorVacunacion.altaEntregaVacunas("lote_0", this.sqlDate, -20, 40, "Navarra");

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Entregas where loteVacunas= 'lote_0'");

		assertEquals("lote_0", this.vector_comprobacion.get(2));

	}

	@Test(expected = Exception.class)
	public void testRegistrarVacunacion1() throws SQLException, Exception {

		TipoVacuna tipo = new TipoVacuna("covid", "PFIZER", this.sqlDate.toString());

		GestorVacunacion.registrarVacunacion(null, "Sergio", "Diaz de la Peña", "03719854Y", tipo);

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Vacunacion where dni_paciente= '03962854T'");

		

	}
	
	@Test(expected = Exception.class)
	public void testRegistrarVacunacion2() throws SQLException, Exception {

		TipoVacuna tipo = new TipoVacuna("covid", "PFIZER", this.sqlDate.toString());

		GestorVacunacion.registrarVacunacion(this.sqlDate, "Fernando", "Guerrero Cano", "03962854T", null);

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Vacunacion where dni_paciente= '03962854T'");

	

	}
	
	@Test
	public void testRegistrarVacunacion3() throws SQLException, Exception {

		TipoVacuna tipo = new TipoVacuna("covid", "PFIZER", this.sqlDate.toString());

		GestorVacunacion.registrarVacunacion(this.sqlDate, "Marcelino", "Diaz Alba", "03997124P", tipo);

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Vacunacion where dni_paciente= '03997124P'");

		assertEquals("03997124P", this.vector_comprobacion.get(2).toString());

	}
	
	@Test(expected = Exception.class)
	public void testRegistrarVacunacion4() throws SQLException, Exception {

		TipoVacuna tipo = new TipoVacuna("covid", "PFIZER", this.sqlDate.toString());

		GestorVacunacion.registrarVacunacion(this.sqlDate, null, null,null, tipo);

		this.vector_comprobacion = AgenteBD.getAgente().select("Select * from Vacunacion where dni_paciente= '03962854T'");

		

	}

	@Test(expected = Exception.class)
	public void testSeleccionarPrioridad1() throws Exception {
		
		GestorVacunacion.seleccionarPrioridad(-10);
		
	}
	
	@Test
	public void testSeleccionarPrioridad2() throws Exception {
		
		
		assertEquals(GrupoPrioridad.BAJA,GestorVacunacion.seleccionarPrioridad(0));
		
	}
	
	@Test
	public void testSeleccionarPrioridad3() throws Exception {
		
		
		assertEquals(GrupoPrioridad.MEDIA,GestorVacunacion.seleccionarPrioridad(1));
		
	}
	
	@Test
	public void testSeleccionarPrioridad4() throws Exception {
		
		
		assertEquals(GrupoPrioridad.ALTA,GestorVacunacion.seleccionarPrioridad(2));
		
	}
	
	@Test(expected = Exception.class)
	public void testSeleccionarPrioridad5() throws Exception {
		
		GestorVacunacion.seleccionarPrioridad(3);
		
	}
	
	@Test(expected = Exception.class)
	public void testSeleccionarPrioridad6() throws Exception {
		
		GestorVacunacion.seleccionarPrioridad(40);
		
	}

}
