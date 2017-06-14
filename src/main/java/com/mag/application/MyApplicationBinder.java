package com.mag.application;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.mag.dao.DAO;
import com.mag.dao.DAOImpl;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
    	System.out.println("******************");
    	System.out.println("CONFIGURING APPLICATION");
        DAO dao;
		dao = new DAOImpl();
        bind(dao).to(DAO.class);
        
    }
}