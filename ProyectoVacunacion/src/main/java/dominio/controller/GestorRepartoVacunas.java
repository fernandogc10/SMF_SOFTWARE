package dominio.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

public class GestorRepartoVacunas {

	public static void altaNuevoLoteVacunas(String id, Date fecha, int cantidad, String farmaceutica) throws Exception {

		
		LoteVacunas lote = new LoteVacunas (id, fecha, cantidad, farmaceutica);
		
		lote.altaNuevoLoteVacunas(lote);
		
		
	}

	public List<EntregaVacunas> calcularEntregasRegion() {
		throw new UnsupportedOperationException();
	}
	
	
	public static void main (String [] args) throws Exception {
		
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		
		altaNuevoLoteVacunas("id1", sqlDate, 2, "farmaciaToledo");
		
	}
}