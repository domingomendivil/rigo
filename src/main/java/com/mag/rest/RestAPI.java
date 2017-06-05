package com.mag.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.mag.beans.User;
import com.mag.dao.DAO;

@Path("/rest")
public class RestAPI {
	
	@Inject
	private DAO dao;
	
	public User getUser(String user){
		return dao.getById(user,User.class);
	}

}
