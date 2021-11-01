package dominio.controller;

import java.util.Date;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.GrupoPrioridad;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.TipoVacuna;

public class GestorVacunacion {

	public void altaEntregaVacunas(String aLote, Date aFecha, int aCantidad, int aPrioridad, String rgn) {

		GrupoPrioridad grupo = seleccionarPrioridad(aPrioridad);

		RegionEnum region = RegionEnum.valueOf(rgn);

		// EntregaVacunas nuevaEntrega = new EntregaVacunas(aFecha,
		// aCantidad,tipoVacuna, region, grupo);

	}

	public void registrarVacunacion(Date aFecha, String aNombre, String aApellidos, String aNif, TipoVacuna aTipo) {

	}

	public GrupoPrioridad seleccionarPrioridad(int prioridad) {

		GrupoPrioridad grupo = null;

		if (prioridad == 0) {

			grupo = GrupoPrioridad.BAJA;

		} else if (prioridad == 1) {

			grupo = GrupoPrioridad.MEDIA;
		} else if (prioridad == 2) {

			grupo = GrupoPrioridad.ALTA;
		}

		return grupo;

	}

}