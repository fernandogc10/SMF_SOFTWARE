package persistencia;

import java.sql.SQLException;
import java.util.Vector;

import dominio.entitymodel.LoteVacunas;

public class LoteVacunasDAO<E> extends AgenteBD {

	public LoteVacunasDAO() throws SQLException{
		super();

	}


	public static void insertarLoteVacunas(LoteVacunas aLote) throws SQLException, Exception{
		
		if (aLote.get_id() == null || aLote.get_fecha() == null || aLote.get_cantidad() <= 0)
			throw new Exception ("No se permiten valores nulos, negativos o cantidades de 0");

		String consulta = "INSERT INTO lotevacunas (id, fecha, cantidad, farmaceutica) VALUES (" + "'" + aLote.get_id()
				+ "'" + "," + "'" + aLote.get_fecha() + "'" + "," + +aLote.get_cantidad() + "," + "'"
				+ aLote.get_farmaceutica() + "')";

		AgenteBD.getAgente().insert(consulta);
		

	}
}
