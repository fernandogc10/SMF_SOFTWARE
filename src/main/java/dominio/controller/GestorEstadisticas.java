package dominio.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.Vacunacion;

public class GestorEstadisticas {
	
	static List<Vacunacion> listaVacunados = new ArrayList<>();

	public static List<Vacunacion> consultarTotalVacunados() throws SQLException{
		
		
		listaVacunados = Vacunacion._vacunacionDao.seleccionarVacunaciones();
		
		return listaVacunados;
		
		
	}

	public static List<Vacunacion> consultarTotalVacunadosPorRegion(RegionEnum aRegion) throws SQLException{
		
		listaVacunados = Vacunacion._vacunacionDao.seleccionarVacunaciones(aRegion);
		
		return listaVacunados;
		
	}
	

	public void consultarPorcentajeVacunadosSobreRecibidas() throws SQLException{
		
		Vacunacion._vacunacionDao.consultarPorcentajeVacunadosSobreRecibidas();
	}

	public void consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum aRegion) throws Exception {
		
		Vacunacion._vacunacionDao.consultarPorcentajeVacunadosSobreRecibidasEnRegion(aRegion);
			
		
	}
}