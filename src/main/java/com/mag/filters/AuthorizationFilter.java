package com.mag.filters;

import java.io.IOException;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.mag.beans.User;
import com.mag.security.AuthenticationException;
import com.mag.security.Authenticator;
import com.mag.security.RestSecurityContext;


@Provider
@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class AuthorizationFilter implements ContainerRequestFilter {

	private Authenticator authenticator;

	
	public void filter(ContainerRequestContext arg0) throws IOException {
		if (arg0.getHeaders()!=null){
			List<String> auth = arg0.getHeaders().get("Authorization");
			String authstr = auth.get(0);
			User user;
			try {
				user = authenticator.getUser(authstr);
				SecurityContext sc = new RestSecurityContext(user);
				arg0.setSecurityContext(sc);
			} catch (AuthenticationException e) {
				throw new WebApplicationException(Status.UNAUTHORIZED);
			}
			
		}	
	}
}