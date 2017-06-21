package com.mag.security;

import java.util.Base64;

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
		byte[] decoded = Base64.getDecoder().decode(authorization);
		String aut = new String(decoded);
		String[] res = aut.split(REGEX);
		return res[0];
	}
	
	public User getUser(String authorization) throws AuthenticationException{
		try{
			String userStr = getUserStr(authorization);
			String password = getPassword(authorization);
			if (validate(userStr,password)){
				return dao.getById(userStr,User.class);
			}else{
				throw new AuthenticationException();
			}
		}catch(IllegalArgumentException e){
			throw new AuthenticationException(e);
		}
		
		
	}

	private boolean validate(String userStr, String password) {
		return passwordValidator.validate(userStr, password);
	}

	private String getPassword(String authorization) {
		byte[] decoded = Base64.getDecoder().decode(authorization);
		String aut = new String(decoded);		
		String[] res = aut.split(REGEX);
		return res[1];
	}


}
