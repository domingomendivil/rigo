package com.mag.security;

import java.security.Principal;
import java.util.HashSet;

import javax.ws.rs.core.SecurityContext;

public class RestSecurityContext implements SecurityContext {
	private UserPrincipal userPrincipal;
	private HashSet<String> roles;
	
	public RestSecurityContext(String user,HashSet<String> roles){
		userPrincipal = new UserPrincipal(user);
	}

	
	public boolean isUserInRole(String aRol) {
		return roles.contains(aRol);
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