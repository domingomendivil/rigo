package com.mag.security;

import com.mag.dao.DAO;
import com.mag.google.GoogleApi;

/**
 * 
 * @author d0178
 *
 */
public class Authenticator {
	
	private GoogleApi googleApi;
	
	private DAO dao;
	
	
	
	/**
	 * Authenticates a user, bases on the authorization credentials
	 * @param authorization
	 * @return
	 */
	public boolean authenticate(String authorization){
		return true;
	}

	public String getUser(String authstr) {
		// TODO Auto-generated method stub
		return null;
	}

}
