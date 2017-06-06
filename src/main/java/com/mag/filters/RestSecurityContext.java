package com.mag.filters;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.mag.security.UserPrincipal;

public class RestSecurityContext implements SecurityContext {

	
	public boolean isUserInRole(String arg0) {
		if (arg0.equals("Supervisor")){
			return true;
		}else if (arg0.equals("Administrator")){
			return false;	
		}else{
			return false;
		}
	}
	
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Principal getUserPrincipal() {
		return new UserPrincipal("pepe");
		
	}

	
	public String getAuthenticationScheme() {
		return "userPassword";
	}

}