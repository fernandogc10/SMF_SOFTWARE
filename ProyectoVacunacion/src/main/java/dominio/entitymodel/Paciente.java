package dominio.entitymodel;

import java.util.Vector;
import dominio.entitymodel.Vacunacion;

public class Paciente {
	private String _dni;
	private String _nombre;
	private String _apellidos;
	public Vector<Vacunacion> _unnamed_Vacunacion_ = new Vector<Vacunacion>();
	public RegionEnum _region;
	public GrupoPrioridad _grupo;
}