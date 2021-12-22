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

	public static List<Vacunacion> consultarTotalVacunadosPorRegion(RegionEnum aRegion) throws SQLException, Exception{
		
		if(aRegion == null) throw new Exception("La región no puede ser nula");
		
		listaVacunados = Vacunacion._vacunacionDao.seleccionarVacunaciones(aRegion);
		
		return listaVacunados;
		
	}
	

	public static String consultarPorcentajeVacunadosSobreRecibidas() throws SQLException{
		
		return Vacunacion._vacunacionDao.consultarPorcentajeVacunadosSobreRecibidas();
	}

	public static String consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum aRegion) throws SQLException, Exception {
		
		if(aRegion == null) throw new Exception("La región no puede ser nula");
		
		return Vacunacion._vacunacionDao.consultarPorcentajeVacunadosSobreRecibidasEnRegion(aRegion);
			
		
	}
}