package dominio.controller;

import java.util.Date;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.GrupoPrioridad;
import dominio.entitymodel.TipoVacuna;

public class GestorVacunacion {

	public void altaEntregaVacunas(String aLote, Date aFecha, int aCantidad, int aPrioridad) {
		
		EntregaVacunas nuevaEntrega = new EntregaVacunas(aFecha, aCantidad);
		
		if (aPrioridad == 0) {
			
			GrupoPrioridad grupo = GrupoPrioridad.BAJA;
			
		}else if (aPrioridad == 1){
			
			GrupoPrioridad grupo = GrupoPrioridad.MEDIA;			
		}else if (aPrioridad == 2){
			
			GrupoPrioridad grupo = GrupoPrioridad.ALTA;			
		}
		
		
		
		
			
			
		
	}

	public void registrarVacunacion(Date aFecha, String aNombre, String aApellidos, String aNif, TipoVacuna aTipo) {
		
		
		
		
	}
}