package com.mag.rest;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.mag.beans.User;
import com.mag.dao.DAO;

@Path("/rest")
public class RestAPI {
	
	@Inject
	private DAO dao;
	
	@Context
	private HttpServletRequest req;
	
	@GET
	@Path("/currentUser")
	@RolesAllowed({"administrator","operator"})
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public User getUser(){
		String user = "d0178";
		return dao.getById(user,User.class);
	}
	
	@GET
	@Path("/hola")
	public String getHola(){
		return "hola";
	}


	private String getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
