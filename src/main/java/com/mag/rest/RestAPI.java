package com.mag.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.mag.beans.User;
import com.mag.dao.DAO;

@Path("/rest")
public class RestAPI {
	
	@Inject
	private DAO dao;
	
	@GET
	@Path("/currentUser")
	public User getUser(){
		String user =getCurrentUser();
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
