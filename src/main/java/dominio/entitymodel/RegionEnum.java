package dominio.entitymodel;

import java.util.Vector;
import dominio.entitymodel.EntregaVacunas;

public enum RegionEnum {
	
	MADRID("Madrid"), CATALUÑA("Cataluña"), ANDALUCÍA ("Andalucía"), GALICIA("Galicia")
	,VALENCIA("Valencia"), ISLASBALEARES("Islas Baleares"), CANARIAS("Canarias"),
	PAISVASCO ("País Vasco"), ASTURIAS("Asturias"), CANTABRIA("Cantabria"), MURCIA("Murcia"),
	NAVARRA("Navarra"), LARIOJA("La Rioja"), ARAGON("Aragón"), CASTILLAYLEON("Castilla y León"),
	CASTILLALAMANCHA("Castilla la Mancha"), EXTREMADURA("Extremadura");
	
	private String nombre;
	
	private RegionEnum(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Vector<EntregaVacunas> _entregas = new Vector<EntregaVacunas>();
}