package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.dto.TestValues;
import com.project.jdUtility.JDBCUtility;

public class ReportController {
	Connection connection = null;
	PreparedStatement statement= null;
	public ArrayList<TestValues> getDetails() throws Exception {
		ArrayList<TestValues> list = new ArrayList<>();
		TestValues test1;
		try {
			connection = JDBCUtility.getConnection();
			
			statement = connection.prepareStatement("select * from test");
			ResultSet data = statement.executeQuery();
			while(data.next()) {
				test1 = new TestValues();
				String name = data.getString(1);
				test1.setName(name);
				String password = data.getString(2);
				test1.setPassword(password);
				int age = data.getInt(3);
				test1.setAge(age);
				System.out.println(name+" "+password+" "+age);
				list.add(test1);
			}
		} catch (SQLException e) {
			throw new Exception("Cannot retrieve the values");
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new Exception("clossing connection error");
			}
		}
		return list;
	}

}
