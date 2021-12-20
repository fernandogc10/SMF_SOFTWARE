package dominio.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
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

		LoteVacunas lote = new LoteVacunas(aLote,sqlDate, "covid", 100);


		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion(Region);

		nuevaEntrega._entregaDao.insertarEntrega("Insert into Entregas (fecha, cantidad, loteVacunas, region, tipoVacuna, GrupoPrioridad) values"
						+ " ('" + nuevaEntrega.get_fecha().toString() + "'," + nuevaEntrega.get_cantidad() + ",'"
						+ lote.get_id() + "', '" + Region + "','" + nuevaEntrega.get_tipo().get_Nombre() + "',"
						+ nuevaEntrega.get_grupoPrioridad().get_grupoPrioridad() + ")");

	}

	public static void registrarVacunacion(Date aFecha, String aNombre, String aApellidos, String aNif,
			TipoVacuna aTipo) throws SQLException, Exception {
		
		Random r = new Random();
		int num = r.nextInt(4);

		RegionEnum region = RegionEnum.values()[num];

		Paciente paciente = new Paciente(aNif, aNombre, aApellidos);
		paciente.set_Region(region);

		Boolean isSegundaDosis = null;

		Vector<Object> vector = new Vector<>();

		vector = AgenteBD.getAgente()
				.select("Select * from Vacunacion where dni_paciente ='" + paciente.get_dni() + "'");

		if (vector.size() == 1) {

			isSegundaDosis = true;

		} else if (vector.size() == 0) {

			isSegundaDosis = false;
		} else {

			return;
		}

		Vacunacion nuevaVacunacion = new Vacunacion(aFecha, isSegundaDosis);

		nuevaVacunacion.set_Paciente(paciente);

		nuevaVacunacion.set_TipoVacuna(aTipo);

		nuevaVacunacion._vacunacionDao.insertarVacunacion(nuevaVacunacion);

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