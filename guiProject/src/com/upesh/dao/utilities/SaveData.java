package com.upesh.dao.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveData {

	public static boolean getResultOfQuery(String query){
		ResultSet rs =null;
		try {
			Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"APP_LTRY","LOTTERY");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	return false;	
	}
}
