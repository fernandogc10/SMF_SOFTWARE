package dominio.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;
import persistencia.AgenteBD;

public class GestorRepartoVacunas {

	public static void altaNuevoLoteVacunas(Date fecha, String tipo, int cantidad) throws Exception {

		LoteVacunas lote = new LoteVacunas(fecha, tipo, cantidad);

		LoteVacunas.altaNuevoLoteVacunas(lote);

	}

	public static List<EntregaVacunas> calcularEntregasRegion() throws SQLException, Exception { // devuelve una lista
																									// donde se deberian
																									// de entregar

		EntregaVacunas entrega = new EntregaVacunas();

		List<EntregaVacunas> lista = new ArrayList<>();

		lista.addAll(entrega._entregaDao.seleccionarEntregas());

		return lista;

	}

}