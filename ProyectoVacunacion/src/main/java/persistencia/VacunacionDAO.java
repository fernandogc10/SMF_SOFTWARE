package persistencia;

import dominio.entitymodel.Vacunacion;

import java.sql.SQLException;
import java.util.List;

import dominio.entitymodel.RegionEnum;

public class VacunacionDAO<E> extends AgenteBD {

	public VacunacionDAO() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insertarVacunacion(Vacunacion aVacunacion) {
		throw new UnsupportedOperationException();
	}

	public List<Vacunacion> seleccionarVacunaciones() {
		throw new UnsupportedOperationException();
	}

	public List<Vacunacion> seleccionarVacunaciones(RegionEnum aRegion) {
		throw new UnsupportedOperationException();
	}
}