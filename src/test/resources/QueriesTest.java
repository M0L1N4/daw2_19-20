package test.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import main.resources.Queries;

public class QueriesTest {

	@Test
	public void CreateTableUsersTest(){
		String res = Queries.createTableUsers();
		assertEquals(res, "CREATE TABLE IF NOT EXISTS Users (cod_user INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nick varchar(25), pass varchar(20), email varchar(50));");
	}

}
