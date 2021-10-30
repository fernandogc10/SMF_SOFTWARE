package dominio.entitymodel;

import java.util.Vector;
import dominio.entitymodel.Paciente;
import dominio.entitymodel.EntregaVacunas;

public enum GrupoPrioridad {
	
	ALTA("Alta", 2), MEDIA("media", 1), BAJA("baja", 0);
	
	private String nombre;
	private int prioridad;
	
	private GrupoPrioridad(String nombre, int prioridad) {
		this.nombre=nombre;
		this.prioridad=prioridad;
	}
	
	public Vector<Paciente> _pacientes = new Vector<Paciente>();
	public Vector<EntregaVacunas> _entregas = new Vector<EntregaVacunas>();
}