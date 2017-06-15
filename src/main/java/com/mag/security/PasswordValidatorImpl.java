package com.mag.security;

import javax.inject.Inject;

import com.mag.beans.User;
import com.mag.dao.DAO;

public class PasswordValidatorImpl implements PasswordValidator {
	
	@Inject
	private DAO dao;
	
	public boolean validate(String userStr,String password){
		User user  = dao.getById(userStr,User.class);
		return user.getPassword().equals(password);
	}

}
