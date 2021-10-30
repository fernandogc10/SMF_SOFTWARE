package persistencia;

import java.sql.SQLException;
import java.util.List;
import dominio.entitymodel.RegionEnum;

import dominio.entitymodel.EntregaVacunas;
import dominio.entitymodel.LoteVacunas;

public class EntregaDAO<E> extends AbstractEntityDAO<E> {

	public void insertarEntrega(EntregaVacunas aEntrega)throws SQLException, Exception {
		
			
			String consulta = "INSERT INTO lotevacunas (id, fecha, cantidad, farmaceutica) VALUES ("+
			"'" +aLote.get_id()+ "'" +","+ "'" + aLote.get_fecha()+ "'" +","+  + aLote.get_cantidad()+","+ "'" 
					+ aLote.get_farmaceutica()+"');";
			
			AgenteBD.getAgente().insert(consulta);
		
	}

	public List<EntregaVacunas> seleccionarEntregas(RegionEnum aRegion) {
		throw new UnsupportedOperationException();
	}
}