package com.mag.security;

import java.util.Date;
import java.util.HashSet;

import com.mag.beans.Rol;
import com.mag.beans.User;

/**
 * 
 * @author d0178
 *
 */
public class AuthenticatorBroker implements Authenticator{
	

	
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
		System.out.println("AuthenticatorBroker getUser");
		User user = new User();
		user.setUserName("d0178");
		user.setFirstname("Domingo");
		user.setSecondname("Mendivil");
		user.setDateOfBirth(new Date());
		user.setPassword("a");
		HashSet<Rol> roles = new HashSet<Rol>();
		Rol aRole = new Rol();
		aRole.setId("1");
		aRole.setName("operator");
		roles.add(aRole);
		user.setRoles(roles);
		System.out.println("AuthenticatorBroker getUser result "+user.getUserName());
		return user;
		//Authenticator aut = getAuthenticator(authstr);
		//return aut.getUser(authstr);
	}

}
