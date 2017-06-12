package com.mag.dao;

import com.mag.beans.User;

public class DAOImplTest {
	
	private DAOImpl dao = new DAOImpl();
	
	public void testUser(){
		dao.getById("d0178",User.class);
	}

}
