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

	public EntregaVacunas(Date fecha, int cantidad, TipoVacuna tipo, RegionEnum region, 
			GrupoPrioridad grupo, LoteVacunas lote) {

		this._fecha = fecha;
		this._cantidad = cantidad;
		this._tipo = tipo;
		this._region = region;
		this._grupoPrioridad = grupo;
		this._lote = lote;
		
		_entregaDao = new EntregaDAO();
	}
}