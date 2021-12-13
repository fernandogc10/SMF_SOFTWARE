package persistencia;

import java.sql.*;
import org.apache.derby.jdbc.EmbeddedDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class AgenteBD {

	protected static AgenteBD mInstancia = null;

	final static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	final static String CONNECTION_STRING = "jdbc:derby:iso2_db;create=true";
	final static String DBNAME = "iso2_db";

	static Connection conn;
	static PreparedStatement pstmt;
	static Statement stmt;
	static ResultSet rs = null;

	public AgenteBD() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);

		crearBaseDatosSinoExiste();
	}

	public static AgenteBD getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new AgenteBD();
		}
		return mInstancia;
	}

	public static Vector<Object> select(String SQL) throws SQLException {

		Vector<Object> vectorDevuelto = new Vector<>();

		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);

		conn = DriverManager.getConnection(CONNECTION_STRING);
		conn.setAutoCommit(false);

		stmt = conn.createStatement();

		try {

			rs = stmt.executeQuery(SQL);

			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {

				for (int i = 1; i <= rsmd.getColumnCount(); i++) {

					vectorDevuelto.add(rs.getObject(i));
				}

			}

			conn.commit();
		} catch (SQLException ex) {
			System.out.println("in connection" + ex);
		}

		return vectorDevuelto;
	}

	public void insert(String SQL) throws SQLException {

		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);

		conn = DriverManager.getConnection(CONNECTION_STRING);
		conn.setAutoCommit(false);

		stmt = conn.createStatement();

		try {

			stmt.executeUpdate(SQL);

			conn.commit();

		} catch (SQLException ex) {
			System.out.println("in connection" + ex);
		}

	}

	public static void crearBaseDatosSinoExiste() throws SQLException {

		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);

		conn = DriverManager.getConnection(CONNECTION_STRING);
		conn.setAutoCommit(false);

		String createSQL = "create table LoteVacunas " + "(id varchar(50) not null, fecha date not null,"
				+ "cantidad integer not null,farmaceutica varchar(30),constraint primary_key primary key (id))";

		String createSQL2 = "create table Entregas " + "(fecha date not null, cantidad integer not null,"
				+ "loteVacunas varchar(50) not null,region varchar(30),tipoVacuna varchar(20) not null, GrupoPrioridad integer not null, "
				+ "constraint pr primary key (fecha))";

		String createSQL3 = "create table Vacunacion " + "(fecha date not null, Dosis varchar(20) not null,"
				+ "dni_paciente varchar(50) not null, nombre_paciente varchar(30) not null, "
				+ "apellidos_paciente varchar(50) not null, tipoVacuna varchar(30),constraint pr2 primary key (fecha))";

		try {

			stmt = conn.createStatement();
			
			stmt.execute("drop table LoteVacunas");
			stmt.execute("drop table Entregas");
			stmt.execute("drop table Vacunacion");

			stmt.execute(createSQL);
			stmt.execute(createSQL2);
			stmt.execute(createSQL3);
			
			


			stmt.close();

			conn.commit();

		} catch (SQLException ex) {
			System.out.println("in connection" + ex);
		}

		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException ex) {
			if (((ex.getErrorCode() == 50000) && ("XJ015".equals(ex.getSQLState())))) {
			} else {
				System.err.println("Derby did not shut down normally");
				System.err.println(ex.getMessage());
			}
		}
	}

}