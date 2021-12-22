package dominio.controller;

import java.sql.SQLException;
import java.util.Date;
<<<<<<< HEAD
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

		LoteVacunas lote = new LoteVacunas(sqlDate, "covid", 100);


		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion(Region);

		nuevaEntrega._entregaDao.insertarEntrega("Insert into Entregas (fecha, cantidad, loteVacunas, region, tipoVacuna, GrupoPrioridad) values"
						+ " ('" + nuevaEntrega.get_fecha().toString() + "'," + nuevaEntrega.get_cantidad() + ",'"
						+ lote.get_id() + "', '" + Region + "','" + nuevaEntrega.get_tipo().get_Nombre() + "',"
						+ nuevaEntrega.get_grupoPrioridad().get_grupoPrioridad() + ")");

	}

	public static void registrarVacunacion(Date aFecha, String aNombre, String aApellidos, String aNif,
			TipoVacuna aTipo) throws SQLException, Exception {

		Paciente paciente = new Paciente(aNif, aNombre, aApellidos);

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

=======
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
		
		

		if(aLote == null || aFecha == null || aCantidad <=0 || aPrioridad <0 || aPrioridad >2)
			throw new Exception("No se permiten parámetros nulos, negativos o la prioridad "
					+ "fuera de su rango (0<prioridad<2");
		
		Vector<Object> vector = new Vector<>();
		EntregaVacunas nuevaEntrega = new EntregaVacunas(aFecha, aCantidad);

		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		nuevaEntrega.set_grupoPrioridad(seleccionarPrioridad(aPrioridad));

		LoteVacunas lote = new LoteVacunas(aLote,sqlDate, "covid", 100);
		
		nuevaEntrega.setLoteVacunas(lote);


		nuevaEntrega.setTipoVacuna(lote.get_TipoVacunas());

		nuevaEntrega.setRegion(Region.toUpperCase());


		nuevaEntrega._entregaDao.insertarEntrega(nuevaEntrega);

	}

	public static void registrarVacunacion(Date aFecha, String aNombre, String aApellidos, String aNif,
			TipoVacuna aTipo) throws SQLException, Exception{
		
		if (aFecha == null || aNombre == null || aApellidos == null || aNif == null || aTipo.get_Nombre() == ""
				|| aTipo.get_Nombre() == null) throw new Exception("No se permiten valores nulos o vacíos.");
		
		Random r = new Random();
		int num = r.nextInt(10);

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

	public static GrupoPrioridad seleccionarPrioridad(int prioridad) throws Exception{
		
		if (prioridad < 0 || prioridad > 2) throw new Exception ("No se permiten a valores "
				+ "menores de 0 o mayores de 2 para prioridad");

		GrupoPrioridad grupo = null;

		if (prioridad == 0) {

			grupo = GrupoPrioridad.BAJA;

		} else if (prioridad == 1) {

			grupo = GrupoPrioridad.MEDIA;
		} else if (prioridad == 2) {

			grupo = GrupoPrioridad.ALTA;
		}
		
>>>>>>> refs/remotes/origin/development
		return grupo;

	}

}