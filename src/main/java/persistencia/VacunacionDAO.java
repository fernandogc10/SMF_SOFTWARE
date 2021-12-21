package persistencia;

import dominio.entitymodel.Vacunacion;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dominio.controller.GestorRepartoVacunas;
import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.Paciente;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.TipoVacuna;

public class VacunacionDAO<E> extends AgenteBD {

	static List<Vacunacion> listaVacunados;

	public VacunacionDAO() throws SQLException{
		super();
		this.listaVacunados = new ArrayList<>();

	}

	public static void insertarVacunacion(Vacunacion nuevaVacunacion) throws SQLException{

		AgenteBD.getAgente().insert(
				"Insert into Vacunacion (fecha, Dosis, dni_paciente, nombre_paciente, apellidos_paciente, tipoVacuna, Region) values"
						+ "('" + nuevaVacunacion.get_fechaVacunacion().toString() + "','" + ""
						+ nuevaVacunacion.get_isSegundaDosis().toString() + "','"
						+ nuevaVacunacion.get_paciente().get_dni() + "','" + nuevaVacunacion.get_paciente().get_Nombre()
						+ "','" + nuevaVacunacion.get_paciente().get_Apellidos() + "','"
						+ nuevaVacunacion.get_tipoVacuna().get_Nombre() + "','"
						+ nuevaVacunacion.get_paciente().get_Region().toString() + "')");
		
		Vector<Object> vector = new Vector<>();
		vector = AgenteBD.getAgente().select("Select * from Vacunacion");
		System.out.println(vector.size());
	}

	public static List<Vacunacion> seleccionarVacunaciones() throws SQLException {

		Vector<Object> vector = new Vector<>();
		Vacunacion vacunacion;
		Paciente paciente;
		TipoVacuna tipoVacuna;

		vector = AgenteBD.getAgente().select("Select * from Vacunacion");

		for (int i = 0; i < vector.size(); i += 7) {
			
			System.out.println("FERNANDO " + vector.elementAt(i+3).toString());

			vacunacion = new Vacunacion((Date) vector.elementAt(i + 0),
					Boolean.parseBoolean((vector.elementAt(i + 1).toString())));
			paciente = new Paciente(vector.elementAt(i + 2).toString(), vector.elementAt(i + 3).toString(),
					vector.elementAt(i + 4).toString());
			tipoVacuna = new TipoVacuna(vector.elementAt(i + 5).toString(), null, null);

			vacunacion.set_Paciente(paciente);
			vacunacion.get_paciente().set_Region(RegionEnum.valueOf(vector.elementAt(i + 6).toString()));
			vacunacion.set_TipoVacuna(tipoVacuna);

			listaVacunados.add(vacunacion);

		}
		System.out.println(listaVacunados);
		return listaVacunados;
	}

	public static List<Vacunacion> seleccionarVacunaciones(RegionEnum aRegion) throws SQLException {

		Vector<Object> vector = new Vector<>();
		Vacunacion vacunacion;
		Paciente paciente;
		TipoVacuna tipoVacuna;

		vector = AgenteBD.getAgente().select("Select * from Vacunacion where Region= '" + aRegion.toString() + "'");

		for (int i = 0; i < vector.size(); i += 7) {

			vacunacion = new Vacunacion((Date) vector.elementAt(i + 0),
					Boolean.parseBoolean((vector.elementAt(i + 1).toString())));
			paciente = new Paciente(vector.elementAt(i + 2).toString(), vector.elementAt(i + 3).toString(),
					vector.elementAt(i + 4).toString());
			tipoVacuna = new TipoVacuna(vector.elementAt(i + 5).toString(), null, null);

			vacunacion.set_Paciente(paciente);

			vacunacion.get_paciente().set_Region(RegionEnum.valueOf(vector.elementAt(i + 6).toString()));
			vacunacion.set_TipoVacuna(tipoVacuna);

			listaVacunados.add(vacunacion);

		}

		return listaVacunados;

	}

	public static void consultarPorcentajeVacunadosSobreRecibidas() throws SQLException {

		Vector<Object> num_vacunados = new Vector<>();
		Vector<Object> num_dosis_recibidas = new Vector<>();
		int suma = 0;


		num_vacunados = AgenteBD.getAgente().select("Select dni_paciente from Vacunacion");

		AgenteBD.getAgente();
		num_dosis_recibidas = AgenteBD.select("Select cantidad from LoteVacunas");

		for (int i = 0; i < num_dosis_recibidas.size(); i++) {

			suma += (int) num_dosis_recibidas.get(i);
		}

		System.out.println(suma);

		DecimalFormat df = new DecimalFormat("#.##");

		double total = (((int) num_vacunados.get(0))/suma)*100;

		System.out.println("El porcentaje de Vacunados sobre dosis Recibidas es: "+
		df.format(total) + "%");

	}

	public static void consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum region) throws SQLException {

		Vector<Object> num_vacunados = new Vector<>();
		Vector<Object> num_dosis_recibidas = new Vector<>();
		int suma = 0;


		num_vacunados = AgenteBD.getAgente().select("Select '" +region.toString() + "' from Vacunacion");

		AgenteBD.getAgente();
		num_dosis_recibidas = AgenteBD.select("Select cantidad from LoteVacunas");

		for (int i = 0; i < num_dosis_recibidas.size(); i++) {

			suma += (int) num_dosis_recibidas.get(i);
		}

		System.out.println(suma);

		DecimalFormat df = new DecimalFormat("#.##");

		double total = (((int) num_vacunados.get(0))/suma)*100;

		System.out.println("El porcentaje de Vacunados sobre dosis Recibidas es: "+
		df.format(total) + "%");

	}
}