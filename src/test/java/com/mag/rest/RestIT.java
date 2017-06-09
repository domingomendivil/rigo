package com.mag.rest;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

public class RestIT {
	
	
	public void testAutenticateValidUser() throws UnirestException{
		
		String encodedAut = toBase64("d0178:MiPassword");
		GetRequest req = Unirest.get("http://httpbin.org/rest/rest/currentUser")
				  .header("Authorization", encodedAut);
	}

	private String toBase64(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
