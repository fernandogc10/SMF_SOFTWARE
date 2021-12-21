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

public class EntregaDAOTest {
//
	java.util.Date date;
	java.sql.Date sqlDate;
	AgenteBD agentebd;
	Vector<Object> vector = new Vector<>();
	List<EntregaVacunas> listaEntregaVacunas = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		this.agentebd = new AgenteBD();
		this.date = new java.util.Date();
		this.sqlDate = new java.sql.Date(date.getTime());
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testInsertarEntrega() throws Exception {

		

	}

	@Test
	public void testSeleccionarEntregas() throws Exception {
		
		vector = AgenteBD.getAgente().select("Select region from Entregas");
		
		listaEntregaVacunas = EntregaDAO.seleccionarEntregas();
		
		
		
	}


}
