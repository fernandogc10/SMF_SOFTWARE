package persistencia;

import java.sql.*;
import java.util.Vector;

public class AgenteBD {

	protected static AgenteBD instance = null;

	protected static Connection connection = null;;

	private static String url = "jdbc:mysql://127.0.0.1:3306/repartovacunas";

	private static String driver = "com.mysql.cj.jdbc.Driver";
	
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


	private void conectar() throws Exception {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, "root", "password");
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

	public ResultSet delete(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = connection.prepareStatement(SQL);
		ResultSet res = stmt.executeQuery();
		stmt.close();
		desconectar();
		return res;
	}

	public ResultSet update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = connection.prepareStatement(SQL);
		ResultSet res = stmt.executeQuery();
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