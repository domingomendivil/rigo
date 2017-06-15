package com.mag.rest;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.mag.beans.User;
import com.mag.dao.DAO;

@Path("/rest")
public class RestAPI {
	
	@Inject
	private DAO dao;
	
	@Context
	private SecurityContext sc;
	
	@GET
	@Path("/currentUser")
	@RolesAllowed({"operator","administrator"})
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public User getUser(){
		System.out.println("LLAMANDO A GETUSER !!!");
		System.out.println("user principal : "+sc.getUserPrincipal());
		System.out.println("current user "+sc.getUserPrincipal().getName());
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
