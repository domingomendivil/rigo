package com.mag.security;

import javax.inject.Inject;

import com.mag.beans.User;
import com.mag.dao.DAO;

public class BasicAuthenticator implements Authenticator{
	
	@Inject
	private DAO dao;
	
	@Inject
	private PasswordValidator passwordValidator;
	
	private final static String REGEX ="\\:";
	
	private String getUserStr(String authorization){
		String[] res = authorization.split(REGEX);
		return res[0];
	}
	
	public User getUser(String authorization) throws AuthenticationException{
		
		String userStr = getUserStr(authorization);
		String password = getPassword(authorization);
		if (validate(userStr,password)){
			return dao.getById(userStr,User.class);
		}else{
			throw new AuthenticationException();
		}
		
		
	}

	private boolean validate(String userStr, String password) {
		return passwordValidator.validate(userStr, password);
	}

	private String getPassword(String authorization) {
		String[] res = authorization.split(REGEX);
		return res[1];
	}


}
