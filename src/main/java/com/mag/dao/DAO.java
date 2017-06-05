package com.mag.dao;

public interface DAO {

	public <T> T getById(Object id,Class<T> a);
}
