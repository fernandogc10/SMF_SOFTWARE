package dominio.entitymodel;

import java.util.Date;
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
}