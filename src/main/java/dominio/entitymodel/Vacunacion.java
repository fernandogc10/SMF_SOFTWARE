package dominio.entitymodel;

import java.sql.SQLException;
import java.util.Date;

import persistencia.VacunacionDAO;

public class Vacunacion {
	private Date _fecha;
	private boolean _isSegundaDosis;
	public TipoVacuna _vacuna;
	public Paciente _paciente;
	public static VacunacionDAO _vacunacionDao;

	public Vacunacion(Date _fecha, Boolean isSegundaDosis) throws ClassNotFoundException, SQLException {

		this._fecha = _fecha;
		this._isSegundaDosis = isSegundaDosis;
		this._vacunacionDao = new VacunacionDAO();

	}
	
	public Vacunacion() throws ClassNotFoundException, SQLException{

		this._vacunacionDao = new VacunacionDAO();

	}

	public Date get_fechaVacunacion() {

		return _fecha;
	}

	public Boolean get_isSegundaDosis() {
		return _isSegundaDosis;
	}

	public Paciente get_paciente() {
		return this._paciente;
	}

	public void set_Paciente(Paciente nuevoPaciente) {
		this._paciente = nuevoPaciente;
	}

	public TipoVacuna get_tipoVacuna() {
		return _vacuna;
	}

	public void set_TipoVacuna(TipoVacuna tipo) {
		this._vacuna = tipo;
	}
}