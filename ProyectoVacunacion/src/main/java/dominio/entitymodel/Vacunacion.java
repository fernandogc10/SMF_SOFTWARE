package dominio.entitymodel;

import java.util.Date;

import persistencia.VacunacionDAO;

public class Vacunacion {
	private Date _fecha;
	private boolean _isSegundaDosis;
	public TipoVacuna _vacuna;
	public Paciente _paciente;
	public VacunacionDAO _vacunacionDao;
}