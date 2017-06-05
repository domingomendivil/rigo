package com.mag.rest;

import javax.ws.rs.Path;

import com.mag.beans.User;

@Path("/rest")
public class RestAPI {
	
	
	public User getUser(){
		User user=new User();
		return user;
	}

}
