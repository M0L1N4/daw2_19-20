/**
 * 
 */
package test.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import main.resources.ConnectionDB;

/**
 * @author alvaro
 *
 */
public class ConnectionDBTest {

	/**
	 * Test method for {@link main.resources.ConnectionDB#ConnectionDB()}.
	 */
	@Test
	public void testConnectionDB() {
//		fail("Not yet implemented");		
	}

	/**
	 * Test method for {@link main.resources.ConnectionDB#getConnection()}.
	 */
	@Test
	public void testGetConnection() {
		assertEquals("Retorna un objecte Connexió a null", null,ConnectionDB.getConnection());
	}

	/**
	 * Test method for {@link main.resources.ConnectionDB#setConnection(java.sql.Connection)}.
	 */
	@Test
	public void testSetConnection() {
		try {
			ConnectionDB.setConnection(DriverManager.getConnection("jdbc:sqlite:Daw2_DB.db"));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Connection not performed");
		}
	}

	/**
	 * Test method for {@link main.resources.ConnectionDB#openConnection()}.
	 */
	@Test
	public void testOpenConnection() {
		try {
			ConnectionDB.openConnection();
			assertNotNull(ConnectionDB.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Connection not performed");
		}
	}

	/**
	 * Test method for {@link main.resources.ConnectionDB#closeConnection()}.
	 */
	@Test
	public void testCloseConnection() {

	}

	/**
	 * Test method for {@link main.resources.ConnectionDB#emptyStatement()}.
	 */
	@Test
	public void testEmptyStatement() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.resources.ConnectionDB#queryResults()}.
	 */
	@Test
	public void testQueryResults() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.resources.ConnectionDB#closeStatementConnection(java.sql.Statement, java.sql.Connection)}.
	 */
	@Test
	public void testCloseStatementConnection() {
		fail("Not yet implemented");
	}

}