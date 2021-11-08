package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dominio.entitymodel.RegionEnum;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

public class EntregaDAO<E> extends AbstractEntityDAO<E> {

	public void insertarEntrega(EntregaVacunas aEntrega) throws SQLException, Exception {

		// AgenteBD.getAgente().insert(consulta);

	}

	public List<EntregaVacunas> seleccionarEntregas() throws SQLException, Exception {

		Vector<Object> vector = new Vector<>();

		EntregaVacunas entrega;

		List<EntregaVacunas> listaEntregaVacunas = new ArrayList<>();

		String consulta = "INSERT INTO Entregas (fecha, cantidad, loteVacunas,region) VALUES ('10/03/2000',3,'lote1' , 'madrid')";

		AgenteBD.getAgente().insert(consulta);

		vector = AgenteBD.getAgente().select("Select region from Entregas");

		for (RegionEnum region : RegionEnum.values()) {

			for (int i = 0; i < vector.size(); i++) {

				if (!region.toString().equalsIgnoreCase(vector.elementAt(i).toString())) {

					entrega = new EntregaVacunas(region);

					listaEntregaVacunas.add(entrega);

				}
			}

		}

		return listaEntregaVacunas;

	}
}