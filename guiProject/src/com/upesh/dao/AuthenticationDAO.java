package com.upesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.upesh.dao.utilities.ResultSetExtractor;
import com.upesh.vo.LoginVO;

public class AuthenticationDAO {

	
	
	public LoginVO getUserDetails(String userName){
		
		LoginVO loginVo = null;
		ResultSet rs = ResultSetExtractor.getResultOfQuery("SELECT * FROM LOGIN WHERE USER_NAME = "+userName);
		try {
			while(rs.next()){
				loginVo = new LoginVO();
				loginVo.setUserName(rs.getString("USER_NAME"));
				loginVo.setPassword(rs.getString("PASSWORD"));
				loginVo.setLocked(rs.getString("LOCKED").equals("Y")?true:false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginVo;
	}
	
	
}
