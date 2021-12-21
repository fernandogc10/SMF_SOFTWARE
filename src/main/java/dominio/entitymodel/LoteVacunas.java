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
	private int cont = 0;

	public Vector<EntregaVacunas> _entregas = new Vector<EntregaVacunas>();
	static Vector<LoteVacunas> listalotes = new Vector<>();

	public LoteVacunas(String id, Date _fecha, String tipo, int _cantidad) throws SQLException{
		this._fecha = _fecha;

		this._cantidad = _cantidad;
		Random r = new Random();
		num = r.nextInt(4);

		this._farmaceutica = TipoVacuna.Farmaceuticas.values()[num].toString();

		if (id == null) {

			this._id = "lote_" + String.valueOf(cont);
		} else {
			this._id = id;
		}

		_tipo = new TipoVacuna(tipo, this._farmaceutica, _fecha.toString());

		_loteVacunasDao = new LoteVacunasDAO();

	}

	public static void altaNuevoLoteVacunas(LoteVacunas lote) throws SQLException{

		LoteVacunasDAO.insertarLoteVacunas(lote);

		listalotes.add(lote);

	}

	public static int calculoLotes() {

		return listalotes.size();

	}

	public int get_Count() {
		return this.cont;
	}

	public static Vector<LoteVacunas> get_ListaLoteVacunas() {
		return listalotes;
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

	public TipoVacuna get_TipoVacunas() {
		return _tipo;
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