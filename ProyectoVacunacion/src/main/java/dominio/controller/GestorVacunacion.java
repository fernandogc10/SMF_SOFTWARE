package dominio.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.GrupoPrioridad;
import dominio.entitymodel.LoteVacunas;
import dominio.entitymodel.Paciente;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.TipoVacuna;
import dominio.entitymodel.Vacunacion;
import persistencia.AgenteBD;

public class GestorVacunacion {

	public static void altaEntregaVacunas(String aLote, Date aFecha, int aCantidad, int aPrioridad, String Region)
			throws SQLException, Exception {

		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(aFecha, aCantidad);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		nuevaEntrega.set_grupoPrioridad(seleccionarPrioridad(aPrioridad));

		

		//vector = AgenteBD.getAgente().select("Select * from LoteVacunas where id='aLote'");
		
		/*if (vector.isEmpty()) {
			
			System.out.println("No hay lotes.");
			
			return;
		}*/

		LoteVacunas lote = new LoteVacunas (sqlDate, "covid", 100);
		
		
		//LoteVacunas lote = new LoteVacunas((Date) vector.elementAt(0), vector.elementAt(1).toString(),
				//(int) vector.elementAt(2));

		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion(Region);

		AgenteBD.getAgente().insert(
				"Insert into Entregas (fecha, cantidad, loteVacunas, region, tipoVacuna, GrupoPrioridad) values"
						+ " ('" + nuevaEntrega.get_fecha().toString() + "'," + nuevaEntrega.get_cantidad() + ",'"
						+ lote.get_id() + "', '" + Region + "','" + nuevaEntrega.get_tipo().get_Nombre() + "',"
						+ nuevaEntrega.get_grupoPrioridad().get_grupoPrioridad() + ")");

		vector = AgenteBD.getAgente().select("Select * from Entregas");
		
		
		
	}
	
	
	public static void main (String [] args) throws SQLException, Exception {
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		AgenteBD agente = new AgenteBD();
		
		
		altaEntregaVacunas("lote1", sqlDate, 5, 2, "MADRID");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void registrarVacunacion(Date aFecha, String aNombre, String aApellidos, String aNif, String aTipo) {

		Paciente paciente = new Paciente(aNif, aNombre, aApellidos);

		Vacunacion vacunacion = new Vacunacion(aFecha, aTipo, paciente);

	}
	
	
	

	public static GrupoPrioridad seleccionarPrioridad(int prioridad) {

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