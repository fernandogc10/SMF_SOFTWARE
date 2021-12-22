package dominio.entitymodel;

import java.util.Vector;
import dominio.entitymodel.Vacunacion;
//
public class TipoVacuna {
	private String _nombre;
	private String _farmaceutica;
	private String _fechaAprobacion;
	public Vector<Vacunacion> _unnamed_Vacunacion_ = new Vector<Vacunacion>();
	public EntregaVacunas _unnamed_EntregaVacunas_;
	public LoteVacunas _unnamed_LoteVacunas_;

	
	public enum Farmaceuticas {
		PFIZER, ASTRAZENECA, MODERNA, JANSSEN;

	}

	public TipoVacuna(String nombre, String farmaceutica, String fechaAprobacion) {

		this._nombre = nombre;
		this._farmaceutica = farmaceutica;
		this._fechaAprobacion = fechaAprobacion;

	}

	public String get_Nombre() {
		return _nombre;
	}
}