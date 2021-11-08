package dominio.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;
import persistencia.AgenteBD;

public class GestorRepartoVacunas {

	public static void altaNuevoLoteVacunas(Date fecha, String tipo, int cantidad) throws Exception {

		LoteVacunas lote = new LoteVacunas(fecha, tipo, cantidad);

		//LoteVacunas.addLote(lote);

		LoteVacunas.altaNuevoLoteVacunas(lote);

	}

	public static List<EntregaVacunas> calcularEntregasRegion() throws SQLException, Exception { //devuelve una lista donde se deberian de entregar

		
		EntregaVacunas entrega = new EntregaVacunas();
		
		entrega._entregaDao.seleccionarEntregas();
	
		
		return null;

	}

	public static void main(String[] args) throws Exception {

		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		AgenteBD agente = new AgenteBD();

		altaNuevoLoteVacunas(sqlDate, "covid", 2);
		calcularEntregasRegion();

	}
}