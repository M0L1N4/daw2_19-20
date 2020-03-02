/**
 * 
 */
package main.resources;

import java.sql.SQLException;

/**
 * @author alvaro
 *
 */
public class Queries {

	/**
	 * 
	 */
	public Queries() {
		// TODO Auto-generated constructor stub
	}
	
	public static String createTableUsers() {
		String q= "CREATE TABLE IF NOT EXISTS Users (cod_user INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nick varchar(25), pass varchar(20), email varchar(50));";
		return q;
	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
