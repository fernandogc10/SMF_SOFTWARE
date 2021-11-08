package dominio.entitymodel;

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

	public EntregaVacunas(Date fecha, int cantidad) {

		this._fecha = fecha;
		this._cantidad = cantidad;

		_entregaDao = new EntregaDAO();
	}

	public EntregaVacunas(RegionEnum region) {

		this._region = region;

		_entregaDao = new EntregaDAO();
	}

	public EntregaVacunas() {

		_entregaDao = new EntregaDAO();
	}

	public void setRegion(String region) {

		this._region = RegionEnum.valueOf(region);
	}

	public void setGrupoPrioridad(GrupoPrioridad grupo) {

		this._grupoPrioridad = grupo;
	}
}