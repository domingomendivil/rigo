package com.mag.application;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.mag.dao.DAO;
import com.mag.dao.DAOImpl;
import com.mag.security.Authenticator;
import com.mag.security.AuthenticatorBroker;
import com.mag.security.PasswordValidator;
import com.mag.security.PasswordValidatorImpl;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
    	System.out.println("******************");
    	System.out.println("CONFIGURING APPLICATION");
        DAO dao;
		dao = new DAOImpl();
        bind(dao).to(DAO.class);
        AuthenticatorBroker auth = new AuthenticatorBroker();
        bind(auth).to(Authenticator.class);
        bind(new PasswordValidatorImpl()).to(PasswordValidator.class);
        
    }
}