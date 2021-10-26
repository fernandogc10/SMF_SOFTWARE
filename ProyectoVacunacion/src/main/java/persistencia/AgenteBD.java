package persistencia;

import java.sql.*;

public class AgenteBD {
	// instancia del agente
	protected static AgenteBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection connection = null;;
	// Identificador ODBC de la base de datos
	private static String url = "jdbc:mysql://localhost:3307/practicabd?user=alumno&password=alumno";
	// Driven para conectar con bases de datos MySQL
	private static String driver = "com.mysql.jdbc.Driver";

	// Constructor
	private AgenteBD() throws Exception {
		conectar();

	}

	// Implementacion del patron singleton
	// Este patron de diseño permite implementar clases de las cuales
	// solo existir una instancia
	// http://es.wikipedia.org/wiki/Singleton
	public static AgenteBD getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new AgenteBD();
		}
		return mInstancia;
	}

	// Metodo para realizar la conexion a la base de datos
	private void conectar() throws Exception {
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
	}

	// Metodo para desconectar de la base de datos
	public void desconectar() throws Exception {
		connection.close();
	}

	// Metodo para realizar una insercion en la base de datos
	public int insert(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int delete(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = connection.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public Vector<Object> select(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El mŽtodo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */

		Vector<Object> vectoradevolver = new Vector<Object>();
		conectar();
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery(SQL);
		while (res.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(res.getObject(1));
			v.add(res.getObject(2));
			vectoradevolver.add(v);
		}
		stmt.close();
		desconectar();
		return vectoradevolver;

	}
}