package com.ijoy.common.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.service.BaseService;

import tk.mybatis.mapper.common.Mapper;

public  abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected Mapper<T> mapper;
	
	protected abstract void setMapper(Mapper<T> mapper);

	public List<T> findAll(RowBounds rowBounds) {
		System.out.println(mapper);
		return mapper.selectByRowBounds(null, rowBounds);
	}

	public int findCount() {
		System.out.println("进入findCount");
		return mapper.selectCount(null);
	}

	public T get(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	public T update(T t) {
		mapper.updateByPrimaryKey(t);
		return t;
	}

	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	public T insert(T t) {
		 mapper.insert(t);
		 return t;
	}
	
	
}
