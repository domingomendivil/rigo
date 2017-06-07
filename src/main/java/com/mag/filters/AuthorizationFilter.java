package com.mag.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.mag.security.Authenticator;
import com.mag.security.RestSecurityContext;


@Provider
@PreMatching
public class AuthorizationFilter implements ContainerRequestFilter {

	private Authenticator authenticator;
	
	/**
	 * Returns a list of roles for the user 
	 * @param user
	 * @return
	 */
	private HashSet<String> getRoles(String user){
		HashSet<String> hashSet = new HashSet<String>();
		return null;
		
	}
	
	public void filter(ContainerRequestContext arg0) throws IOException {
		if (arg0.getHeaders()!=null){
			List<String> auth = arg0.getHeaders().get("Authorization");
			String authstr = auth.get(0);
			if (authenticator.authenticate(authstr)){
				String user = authenticator.getUser(authstr);
				HashSet<String> roles = getRoles(user);
				SecurityContext sc = new RestSecurityContext(user,roles);
				arg0.setSecurityContext(sc);
			}
		}	
	}
}