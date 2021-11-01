package dominio.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

public class GestorRepartoVacunas {

	public static void altaNuevoLoteVacunas(Date fecha, String tipo, int cantidad) throws Exception {

		LoteVacunas lote = new LoteVacunas(fecha, tipo, cantidad);

		LoteVacunas.addLote(lote);

		LoteVacunas.altaNuevoLoteVacunas(lote);

	}

	public List<EntregaVacunas> calcularEntregasRegion() {

		if (LoteVacunas.calculoLotes() == 0) {
			System.out.println("No hay lotes para repartir");
		} else {
			
			
		}
		return null;

	}

	public static void main(String[] args) throws Exception {

		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		//altaNuevoLoteVacunas("id1", sqlDate, 2, "farmaciaToledo");

	}
}