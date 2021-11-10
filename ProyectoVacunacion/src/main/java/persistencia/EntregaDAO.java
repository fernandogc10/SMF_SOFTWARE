package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dominio.entitymodel.RegionEnum;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

public class EntregaDAO<E> extends AgenteBD {

	List<EntregaVacunas> listaEntregaVacunas = new ArrayList<>();

	public EntregaDAO() throws SQLException, ClassNotFoundException {
		super();

	}

	public void insertarEntrega(EntregaVacunas aEntrega) throws SQLException, Exception {

		// AgenteBD.getAgente().insert(consulta);

	}

	public List<EntregaVacunas> seleccionarEntregas() throws SQLException, Exception {

		Vector<Object> vector = new Vector<>();

		EntregaVacunas entrega;

		vector = AgenteBD.getAgente().select("Select region from Entregas");

		for (RegionEnum region : RegionEnum.values()) {

			for (int i = 0; i < vector.size(); i++) {

				if (!region.toString().equalsIgnoreCase(vector.elementAt(i).toString())) {

					entrega = new EntregaVacunas(region);

					listaEntregaVacunas.add(entrega);

				}
			}

			if (vector.isEmpty()) {

				entrega = new EntregaVacunas(region);

				listaEntregaVacunas.add(entrega);

			}

		}

		System.out.println(listaEntregaVacunas.get(0).get_region().toString());

		return listaEntregaVacunas;

	}
}
