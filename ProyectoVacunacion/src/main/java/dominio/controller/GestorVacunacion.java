package dominio.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.GrupoPrioridad;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.TipoVacuna;
import persistencia.AgenteBD;

public class GestorVacunacion {

	public void altaEntregaVacunas(String aLote, Date aFecha, int aCantidad, int aPrioridad, String rgn) throws SQLException, Exception {

		Vector <Object> vectorRetorno = new Vector <> ();
		
		GrupoPrioridad grupo = seleccionarPrioridad(aPrioridad);

		EntregaVacunas nuevaEntrega = new EntregaVacunas(aFecha, aCantidad);
		
		nuevaEntrega.setGrupoPrioridad(grupo);
		nuevaEntrega.setRegion(rgn);
		
		String consulta = "SELECT * FROM LoteVacunas WHERE Id=' "+ aLote + "';";
		
		vectorRetorno = AgenteBD.getAgente().select(consulta);
		
		LoteVacunas lote = new Lotevacunas(vectorRetorno.elementAt(0)
;
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