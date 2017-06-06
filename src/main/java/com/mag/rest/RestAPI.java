package com.mag.rest;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mag.beans.User;
import com.mag.dao.DAO;

@Path("/rest")
public class RestAPI {
	
	@Inject
	private DAO dao;
	
	@GET
	@Path("/currentUser")
	@PermitAll
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public User getUser(){
		return dao.getById("d0178",User.class);
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
