package dominio.controller;


import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

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
//
public class GestorRepartoVacunas {

	static List<EntregaVacunas> listaentregas = new ArrayList<>();
	
	java.util.Date date;
	java.sql.Date sqlDate;

	public static void altaNuevoLoteVacunas(Date fecha, String tipo, int cantidad) throws SQLException, Exception {


		
			if (cantidad <= 0)
				throw new Exception("Parámetro Cantidad con valor no válido");
			
			if (fecha == null || tipo == null) throw new Exception("Los prámetros no pueden ser null");
			

			LoteVacunas lote = new LoteVacunas(null, fecha, tipo, cantidad);

			lote._loteVacunasDao.insertarLoteVacunas(lote);
			

	}

	public static List<EntregaVacunas> calcularEntregasRegion() throws SQLException { // devuelve una lista
																						// donde se deberian // de
																						// entregar

		EntregaVacunas entrega = new EntregaVacunas();

		listaentregas.addAll(entrega._entregaDao.seleccionarEntregas());

		return listaentregas;


	}

}