package dominio.entitymodel;

import java.util.Date;

import persistencia.VacunacionDAO;

public class Vacunacion {
	private Date _fecha;
	private boolean _isSegundaDosis;
	public TipoVacuna _vacuna;
	public Paciente _paciente;
	public VacunacionDAO _vacunacionDao;
	
	
	
	public Vacunacion (Date _fecha,boolean _isSegundaDosis,TipoVacuna _vacuna,
			Paciente _paciente) {
		
		this._fecha = _fecha;
		this._isSegundaDosis = _isSegundaDosis;
		this._vacuna= _vacuna;
		this._paciente= _paciente;
		
	}
}