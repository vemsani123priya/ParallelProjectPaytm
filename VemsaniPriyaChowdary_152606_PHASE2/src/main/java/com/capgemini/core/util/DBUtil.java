package com.capgemini.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Capgemini123");
		
		return con;
		
	}

}
