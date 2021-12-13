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

	public Paciente(String dni, String nombre, String apellidos) {
		this._dni = dni;
		this._nombre = nombre;
		this._apellidos = apellidos;
	}

	public String get_dni() {

		return _dni;
	}

	public String get_Nombre() {
		return _nombre;
	}

	public String get_Apellidos() {
		return _apellidos;
	}
}