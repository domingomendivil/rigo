package com.mag.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOImpl implements DAO {


    private static EntityManagerFactory factory;
    
	public <T> T getById(Object id,Class<T> a){
		factory = Persistence.createEntityManagerFactory("testjpa");
        EntityManager em = factory.createEntityManager();
        T res;
        res = em.find(a,id);
		return res;
	}

}
