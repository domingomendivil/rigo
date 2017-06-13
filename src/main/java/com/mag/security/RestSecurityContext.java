package com.mag.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.mag.beans.User;

public class RestSecurityContext implements SecurityContext {
	
	private UserPrincipal userPrincipal;
	private User user;
	
	public RestSecurityContext(User user){
		userPrincipal = new UserPrincipal(user.getUserName());
	}

	
	public boolean isUserInRole(String aRol) {
		return user.getRoles().contains(aRol);
	}
	
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Principal getUserPrincipal() {
		return userPrincipal;
		
	}

	
	public String getAuthenticationScheme() {
		return "userPassword";
	}

}