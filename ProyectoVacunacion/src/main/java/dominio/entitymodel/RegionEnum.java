package dominio.entitymodel;

import java.util.Vector;
import dominio.entitymodel.EntregaVacunas;

public enum RegionEnum {
	
	MADRID("Madrid"), CATALUÑA("Cataluña"), ANDALUCÍA ("Andalucía"), GALICIA("Galicia");
	
	private String nombre;
	
	private RegionEnum(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	public Vector<EntregaVacunas> _entregas = new Vector<EntregaVacunas>();
}