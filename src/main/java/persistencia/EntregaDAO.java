package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dominio.entitymodel.RegionEnum;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

public class EntregaDAO<E> extends AgenteBD {

	static List<EntregaVacunas> listaEntregaVacunas = new ArrayList<>();

	public EntregaDAO() throws SQLException{
		

	}

	public static void insertarEntrega(EntregaVacunas nuevaEntrega) throws SQLException,Exception{
		
		if(nuevaEntrega.get_fecha() == null || nuevaEntrega.get_cantidad() <=0 || nuevaEntrega.get_region() == null
				|| nuevaEntrega.get_tipo() == null || nuevaEntrega.get_grupoPrioridad().get_grupoPrioridad() < 0 || nuevaEntrega.get_grupoPrioridad().get_grupoPrioridad() > 2)
			throw new Exception ("No se permiten parámetros nulos, negativos o la prioridad fuera de su rango (0<prioridad<2");

		AgenteBD.getAgente().insert(("Insert into Entregas (fecha, cantidad, loteVacunas, region, tipoVacuna, GrupoPrioridad) values"
				+ " ('" + nuevaEntrega.get_fecha().toString() + "'," + nuevaEntrega.get_cantidad() + ",'"
				+ nuevaEntrega.get_lote().get_id() + "', '" + nuevaEntrega.get_region().toString() + "','" + nuevaEntrega.get_tipo().get_Nombre() + "',"
				+ nuevaEntrega.get_grupoPrioridad().get_grupoPrioridad() + ")"));

	}

	public static List<EntregaVacunas> seleccionarEntregas() throws SQLException{

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
		return listaEntregaVacunas;

	}
}
