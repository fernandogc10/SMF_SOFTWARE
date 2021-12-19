package dominio.controller;

import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.Vacunacion;

public class GestorEstadisticas {
	
	Vacunacion vacunacion = new Vacunacion();

	public void consultarTotalVacunados() throws Exception {
		
		
		
		vacunacion._vacunacionDao.seleccionarVacunaciones();
		
		
	}

	public void consultarTotalVacunadosPorRegion(RegionEnum aRegion) throws Exception {
		
		vacunacion._vacunacionDao.seleccionarVacunaciones(aRegion);
		
	}
	

	public void consultarPorcentajeVacunadosSobreRecibidas() throws Exception {
		
		vacunacion._vacunacionDao.consultarPorcentajeVacunadosSobreRecibidas();
	}

	public void consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum aRegion) {
		
		
		
		
	}
}