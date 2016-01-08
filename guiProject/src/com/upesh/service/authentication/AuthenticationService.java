package com.upesh.service.authentication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.upesh.dao.AuthenticationDAO;
import com.upesh.vo.LoginVO;

public class AuthenticationService {
	
	public static String CONFIG_PATH = "../../../../resources/configuration.properties";

	private AuthenticationDAO authenticationDAO = new AuthenticationDAO();
	
	public boolean authenticate(String password) throws IOException{
		
		Properties props = new Properties();
		InputStream in = getClass().getResourceAsStream(CONFIG_PATH);
		props.load(in);
		String defaultUserName = props.getProperty("defaultUserName");
		LoginVO loginVO = authenticationDAO.getUserDetails(defaultUserName);
		if(loginVO.getPassword().equals(password) && ! loginVO.isLocked()){
			return true;
		}
		return false;
	}

}
