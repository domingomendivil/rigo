package com.mag.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DAOImpl implements DAO {

	private static final String PERSISTENCE_UNIT_NAME = "User";
    private static EntityManagerFactory factory;
    
	public <T> T getById(Object id,Class<T> a){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("SELECT u FROM User u");
		return null;
	}

}
