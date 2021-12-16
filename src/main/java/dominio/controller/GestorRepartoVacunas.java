package dominio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

public class GestorRepartoVacunas {

	public static void altaNuevoLoteVacunas(Date fecha, String tipo, int cantidad) throws Exception {

		LoteVacunas lote = new LoteVacunas(fecha, tipo, cantidad);

		LoteVacunas.altaNuevoLoteVacunas(lote);

	}

	public static List<EntregaVacunas> calcularEntregasRegion() throws Exception { // devuelve una lista
																									// donde se deberian
																									// de entregar

		EntregaVacunas entrega = new EntregaVacunas();

		List<EntregaVacunas> lista = new ArrayList<>();

		lista.addAll(entrega._entregaDao.seleccionarEntregas());

		return lista;

	}

}