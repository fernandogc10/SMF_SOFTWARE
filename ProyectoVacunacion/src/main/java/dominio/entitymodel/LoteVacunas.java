package dominio.entitymodel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import dominio.entitymodel.EntregaVacunas;
import persistencia.LoteVacunasDAO;

public class LoteVacunas {
	private String _id;
	private Date _fecha;
	private int _cantidad;
	private String _farmaceutica;
	public Vector<EntregaVacunas> _entregas = new Vector<EntregaVacunas>();
	public TipoVacuna _tipo;
	public LoteVacunasDAO _loteVacunasDao;
	Vector<LoteVacunas> listalotes;

	public LoteVacunas(String _id, Date _fecha, int _cantidad, String _farmaceutica) {
		this._id = _id;
		this._fecha = _fecha;
		this._cantidad = _cantidad;
		this._farmaceutica = _farmaceutica;

		_loteVacunasDao = new LoteVacunasDAO();
		listalotes = new Vector<LoteVacunas>();
	}

	public static void altaNuevoLoteVacunas(LoteVacunas lote) throws Exception {

		LoteVacunasDAO.insertarLoteVacunas(lote);

	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date get_fecha() {
		return _fecha;
	}

	public void set_fecha(Date _fecha) {
		this._fecha = _fecha;
	}

	public int get_cantidad() {
		return _cantidad;
	}

	public void set_cantidad(int _cantidad) {
		this._cantidad = _cantidad;
	}

	public String get_farmaceutica() {
		return _farmaceutica;
	}

	public void set_farmaceutica(String _farmaceutica) {
		this._farmaceutica = _farmaceutica;
	}
}