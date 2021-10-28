package persistencia;

import java.sql.SQLException;

import dominio.entitymodel.LoteVacunas;

public class LoteVacunasDAO {
	

	public static void insertarLoteVacunas(LoteVacunas aLote) throws SQLException, Exception {
		
		
		AgenteBD.getAgente().insert("INSERT INTO lotevacunas VALUES (" + aLote.get_id()
		+ ","+ aLote.get_fecha() +","+ aLote.get_cantidad()+ ","+ 
		aLote.get_farmaceutica()+");");
		
		
	}
}