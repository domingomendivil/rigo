package com.mag.security;

import com.mag.beans.User;
import com.mag.dao.DAO;

public class PasswordValidatorImpl {
	
	private DAO dao;
	
	public boolean validate(String userStr,String password){
		User user  = dao.getById(userStr,User.class);
		return user.getPassword().equals(password);
	}

}
