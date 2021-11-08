package persistencia;

import java.sql.SQLException;
import java.util.Vector;

import dominio.entitymodel.LoteVacunas;

public class LoteVacunasDAO {

	public static void insertarLoteVacunas(LoteVacunas aLote) throws SQLException, Exception {

		String consulta = "INSERT INTO lotevacunas (id, fecha, cantidad, farmaceutica) VALUES (" + "'" + aLote.get_id()
				+ "'" + "," + "'" + aLote.get_fecha() + "'" + "," + +aLote.get_cantidad() + "," + "'"
				+ aLote.get_farmaceutica() + "')";

		AgenteBD.getAgente().insert(consulta);

		Vector<Object> vector = new Vector<>();

		vector = AgenteBD.getAgente().select("Select * from LoteVacunas");

	}
}