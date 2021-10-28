package persistencia;

import java.sql.*;
import java.util.Vector;

public class AgenteBD {

	protected static AgenteBD instance = null;

	protected static Connection connection = null;;

	private static String url;

	private static String driver = "com.mysql.jdbc.Driver";

	// Constructor
	private AgenteBD() throws Exception {
		conectar();

	}

	// Implementacion del patron singleton

	public static AgenteBD getAgente() throws Exception {
		if (instance == null) {
			instance = new AgenteBD();
		}
		return instance;
	}

<<<<<<< HEAD
	public ResultSet select(String aSql) {
		throw new UnsupportedOperationException();
=======
	private void conectar() throws Exception {
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
>>>>>>> branch 'master' of https://github.com/fernandogc10/SMF_SOFTWARE.git
	}

	public void desconectar() throws Exception {
		connection.close();
	}

	public int insert(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = connection.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public int delete(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = connection.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = connection.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public Vector<Object> select(String SQL) throws SQLException, Exception {

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