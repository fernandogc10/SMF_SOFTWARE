package dominio.entitymodel;

import java.sql.SQLException;
import java.util.Date;

import persistencia.EntregaDAO;

public class EntregaVacunas {
	private Date _fecha;
	private int _cantidad;
	public TipoVacuna _tipo;
	public RegionEnum _region;
	public GrupoPrioridad _grupoPrioridad;
	public LoteVacunas _lote;
	public EntregaDAO _entregaDao;


	public EntregaVacunas(Date fecha, int cantidad) throws SQLException{

		this._fecha = fecha;
		this._cantidad = cantidad;

		_entregaDao = new EntregaDAO();
	}

	public EntregaVacunas(RegionEnum region) throws SQLException{

		this._region = region;

		_entregaDao = new EntregaDAO();
	}

	public EntregaVacunas() throws SQLException{

		_entregaDao = new EntregaDAO();
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

	public TipoVacuna get_tipo() {
		return _tipo;
	}

	public void set_tipo(TipoVacuna _tipo) {
		this._tipo = _tipo;
	}

	public RegionEnum get_region() {
		return _region;
	}

	public void set_region(RegionEnum _region) {
		this._region = _region;
	}

	public GrupoPrioridad get_grupoPrioridad() {
		return _grupoPrioridad;
	}

	public void set_grupoPrioridad(GrupoPrioridad _grupoPrioridad) {
		this._grupoPrioridad = _grupoPrioridad;
	}

	public LoteVacunas get_lote() {
		return _lote;
	}

	public void set_lote(LoteVacunas _lote) {
		this._lote = _lote;
	}

	public void setRegion(String region) {
		

		this._region = RegionEnum.valueOf(region.toUpperCase());
	}



	public void setLoteVacunas(LoteVacunas lote) {

		this._lote = lote;

	}

	public void setTipoVacuna(TipoVacuna tipo) {

		this._tipo = tipo;
	}

}