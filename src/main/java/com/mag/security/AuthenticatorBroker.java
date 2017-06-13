package com.mag.security;

import com.mag.beans.User;

/**
 * 
 * @author d0178
 *
 */
public class AuthenticatorBroker {
	

	
	private String getAuthorizationType(String authstr){
		//TODO
		return null;
	}
	
	private Authenticator getAuthenticator(String authstr){
		String type = getAuthorizationType(authstr);
		if (type.equals("Basic")){
			return new BasicAuthenticator();
		}else if (type.equals("Bearer")){
			return new OAuthAuthenticator();
		}
		return null;
	}
	

	public User getUser(String authstr) throws AuthenticationException{
		Authenticator aut = getAuthenticator(authstr);
		return aut.getUser(authstr);
	}

}
