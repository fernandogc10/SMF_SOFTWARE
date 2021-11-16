package persistencia;

import dominio.entitymodel.Vacunacion;

import java.sql.SQLException;
import java.util.List;

import dominio.entitymodel.RegionEnum;

public class VacunacionDAO<E> extends AgenteBD {

	public VacunacionDAO() throws SQLException, ClassNotFoundException {
		super();

	}

	public void insertarVacunacion(Vacunacion nuevaVacunacion) throws SQLException, Exception {
		
		AgenteBD.getAgente().insert("Insert into Vacunacion (fecha, Dosis, dni_paciente, tipoVacuna) values" + "('"
				+ nuevaVacunacion.get_fechaVacunacion().toString() + "','" + ""
				+ nuevaVacunacion.get_isSegundaDosis().toString() + "','" + nuevaVacunacion.get_paciente().get_dni()
				+ "','" + "" + nuevaVacunacion.get_tipoVacuna().get_Nombre() + "')");
	}

	public List<Vacunacion> seleccionarVacunaciones() {
		throw new UnsupportedOperationException();
	}

	public List<Vacunacion> seleccionarVacunaciones(RegionEnum aRegion) {
		throw new UnsupportedOperationException();
	}
}