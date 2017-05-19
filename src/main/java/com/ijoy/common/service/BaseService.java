package com.ijoy.common.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface BaseService<T> {
	public List<T> findAll(RowBounds rowBounds);
	public int findCount();
	public T get(int id);
	public T update(T t);
	public void delete(int id);
	public T insert(T t);
}
