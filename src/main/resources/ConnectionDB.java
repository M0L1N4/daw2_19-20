package main.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Classe que s'encarrega d'establir la connexió amb la base de dades.
 * Com usar SQLite en projecte java. 
 * @see https://jnjsite.com/sqlite-con-java/
 * @see https://www.tutorialspoint.com/sqlite/index.htm
 * */
public class ConnectionDB {
	
	private static Connection conn = null;
	
	public ConnectionDB() {
		//Nothing
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void setConnection(Connection cnt) {
		conn = cnt;
	}
	
	public static void openConnection() throws SQLException {
		DriverManager.registerDriver(new org.sqlite.JDBC());	
		setConnection(DriverManager.getConnection("jdbc:sqlite:Daw2_DB.db"));
	}
	
	public static void closeConnection() throws SQLException{
		conn.close();
	}

	public static Statement emptyStatement() throws SQLException{
		Statement st;
		st = conn.createStatement();
		return st;
	}
	
	public static ResultSet queryResults() {
		ResultSet rs = null;
		return rs;
	}
	
	public static Boolean closeStatementConnection(Statement st, Connection cnt) {
		
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		   return true;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Class.forName("org.sqlite.JDBC");
		
		DriverManager.registerDriver(new org.sqlite.JDBC());
		  try {

		   // Establim la connexió
		   // Default DB path: /Applications/Eclipse.app/Contents/MacOS/
		   conn = DriverManager.getConnection("jdbc:sqlite:Daw2_DB.db");

		   // Creem un "full en blanc" on escriure les sentències SQL
		   Statement st;
		   st = conn.createStatement();

		   // Eliminem la taula si existeix
		   st.execute("DROP TABLE IF EXISTS tablapruebas;");
		   // Creem una nova taula
		   st.execute("CREATE TABLE tablapruebas (id int primary key, aleatorio int);");

		   // INSERTAR DATOS
		   for (int i = 1; i <= 100; i++) {
		    st.execute("INSERT INTO tablapruebas (id, aleatorio) values ("
		        + i
		        + ", "
		        + Math.floor(Math.random() * 100 + 1) + ");");
		   }

		   // CONSULTA DATOS
		   ResultSet resultados;
		   resultados = st.executeQuery("SELECT * FROM tablapruebas;");

		   // PROCESAR EL RESULTADO
		   while (resultados.next()) {
		    System.out.println("id " + resultados.getString(1)
		      + ": aleatorio " + resultados.getString(2));
		   }

		   // CERRAR
		   resultados.close();
		   st.close();
		   conn.close();

		  } catch (Exception e) {
		   System.out.println("ERROR: " + e.getMessage());
		  }

		 }

	}