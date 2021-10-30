package dominio.entitymodel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;
import dominio.entitymodel.EntregaVacunas;
import persistencia.LoteVacunasDAO;

public class LoteVacunas {
	private String _id;
	private Date _fecha;
	private int _cantidad;
	private String _farmaceutica;
	public TipoVacuna _tipo;
	public LoteVacunasDAO _loteVacunasDao;
	private int num;

	public Vector<EntregaVacunas> _entregas = new Vector<EntregaVacunas>();
	Vector<LoteVacunas> listalotes;

	public enum Farmaceuticas {
		PFIZER, ASTRAZENECA, MODERNA, JANSSEN;

	}

	public LoteVacunas(Date _fecha, String tipo, int _cantidad) {
		this._fecha = _fecha;

		this._cantidad = _cantidad;
		Random r = new Random();
		num = r.nextInt(4);
		
		this._farmaceutica = Farmaceuticas.values()[num].toString();
		UUID idUnico = UUID.randomUUID();
		this._id = idUnico.toString();
		
		
		
		_loteVacunasDao = new LoteVacunasDAO();

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