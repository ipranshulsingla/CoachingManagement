package com.sims.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sims.utils.SQLConstants;

public class UserDAO {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	
	public UserDAO() throws ClassNotFoundException, SQLException{
		con=CommonDAO.getConnection();
	}
	
//************************************************************************************************	
	
	public String checkLogin(String email,String password) throws SQLException  {
			ps=con.prepareStatement(SQLConstants.LOGIN_QUERY);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return (rs.getString("first_name")+" "+rs.getString("last_name"));
			}
			return null;
	}
//************************************************************************************************	
	public String checkEmail(String email) throws SQLException {
		ps=con.prepareStatement(SQLConstants.EMAIL_CHECK_QUERY);
		ps.setString(1,email);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return (rs.getString("first_name")+" "+rs.getString("last_name"));
		}
		return null;
	}
//************************************************************************************************	
	public void resetPassword(String password,String email) throws SQLException {

		ps=con.prepareStatement(SQLConstants.UPDATE_PASSWORD);
		ps.setString(1,password);
		ps.setString(2,email);
		ps.executeUpdate();
	}
//************************************************************************************************
	
}
