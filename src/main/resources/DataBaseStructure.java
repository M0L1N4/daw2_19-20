package main.resources;

import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseStructure {
	
	
	/**
	 * Queries to use:
	 * CREATE TABLE IF NOT EXISTS Users (cod_user INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(25), pass varchar(20), email varchar(50));
	 * @return 
	 * @return 
	 * @return 
	 * 
	 * */
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionDB.openConnection();
		Statement st = ConnectionDB.emptyStatement();
		
		st.execute("CREATE TABLE IF NOT EXISTS Users (cod_user INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nick varchar(25), pass varchar(20), email varchar(50));");
		
		ConnectionDB.closeStatementConnection(st,ConnectionDB.getConnection());
	}
	
	
	
	
}
