package com.sims.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CommonDAO {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection con=null;
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/coaching","postgres","25009717");
		System.out.println("Connection Created with DB");
		return con;
	}
}
