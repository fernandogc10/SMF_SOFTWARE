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


	@Test
	public void testInsertarEntrega1() throws Exception {
		
		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(null, -30);
		
		nuevaEntrega.set_grupoPrioridad(GestorVacunacion.seleccionarPrioridad(-10));

		LoteVacunas lote = new LoteVacunas("lote_1",sqlDate, "covid", 100);
		
		nuevaEntrega.setLoteVacunas(lote);


		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion("Madrid");


		EntregaDAO.insertarEntrega(nuevaEntrega);

	}

	@Test
	public void testSeleccionarEntregas() throws Exception {
		
		vector = AgenteBD.getAgente().select("Select region from Entregas");
		
		listaEntregaVacunas = EntregaDAO.seleccionarEntregas();
		
		
		
	}


}
