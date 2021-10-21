package persistencia;

import dominio.entitymodel.Vacunacion;

import java.util.List;

import dominio.entitymodel.RegionEnum;

public class VacunacionDAO<E> extends AbstractEntityDAO<E> {

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