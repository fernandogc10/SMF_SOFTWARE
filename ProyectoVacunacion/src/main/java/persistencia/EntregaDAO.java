package persistencia;

import java.util.List;
import dominio.entitymodel.RegionEnum;

import dominio.entitymodel.EntregaVacunas;

public class EntregaDAO<E> extends AbstractEntityDAO<E> {

	public void insertarEntrega(EntregaVacunas aEntrega) {
		throw new UnsupportedOperationException();
	}

	public List<EntregaVacunas> seleccionarEntregas(RegionEnum aRegion) {
		throw new UnsupportedOperationException();
	}
}