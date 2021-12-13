package persistencia;

import dominio.entitymodel.Vacunacion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.Paciente;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.TipoVacuna;

public class VacunacionDAO<E> extends AgenteBD {
	
	static List<Vacunacion> listaVacunados;
	
	public static void main (String args[] ) throws Exception {
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Vacunacion vacunacion = new Vacunacion(sqlDate, false);
		
		Paciente paciente = new Paciente("03962854T", "Fernando", "Guerrero Cano");
		
		vacunacion.set_Paciente(paciente);
		
		TipoVacuna tipovacuna = new TipoVacuna("covid", "PFIZER", sqlDate.toString());
		
		vacunacion.set_TipoVacuna(tipovacuna);
		
		insertarVacunacion(vacunacion);
		
		seleccionarVacunaciones();
	}

	public VacunacionDAO() throws SQLException, ClassNotFoundException {
		super();
		this.listaVacunados = new ArrayList<>();

	}

	public static void insertarVacunacion(Vacunacion nuevaVacunacion) throws SQLException, Exception {

		AgenteBD.getAgente().insert("Insert into Vacunacion (fecha, Dosis, dni_paciente, nombre_paciente, apellidos_paciente, tipoVacuna) values" + "('"
				+ nuevaVacunacion.get_fechaVacunacion().toString() + "','" + ""
				+ nuevaVacunacion.get_isSegundaDosis().toString() + "','" + nuevaVacunacion.get_paciente().get_dni()
				+ "','" + nuevaVacunacion.get_paciente().get_Nombre()+ "','"+
				nuevaVacunacion.get_paciente().get_Apellidos()+ "','" + nuevaVacunacion.get_tipoVacuna().get_Nombre() + "')");
	}

	public static List<Vacunacion> seleccionarVacunaciones() throws Exception {
		

		Vector<Object> vector = new Vector<>();
		Vacunacion vacunacion;

		AgenteBD.getAgente();
		vector = AgenteBD.select("Select * from Vacunacion");

		for (int i = 0; i < vector.size(); i++) {
			
			System.out.println(vector.elementAt(i));
			//vacunacion = new Vacunacion((Date)vector.elementAt(i),
					//(boolean)vector.elementAt(i+1));
			
		}
		
		return listaVacunados;
	}

	public List<Vacunacion> seleccionarVacunaciones(RegionEnum aRegion) {
		throw new UnsupportedOperationException();
	}
}