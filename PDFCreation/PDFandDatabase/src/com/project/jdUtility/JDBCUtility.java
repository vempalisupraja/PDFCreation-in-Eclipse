package com.project.jdUtility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class JDBCUtility {
	static Connection connection = null;
	public static Connection getConnection() throws Exception{
		Driver driver = new OracleDriver();
		try {
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kuttu");
		} catch (SQLException e) {
				throw new Exception("DB error occured");
	}
	return connection;
}
}
