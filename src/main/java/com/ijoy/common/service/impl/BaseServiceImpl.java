package com.ijoy.common.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.ijoy.common.service.BaseService;

import tk.mybatis.mapper.common.Mapper;

public  abstract class BaseServiceImpl<T> implements BaseService<T> {
	public String keyName;
	protected Mapper<T> mapper;
	public String getKeyName(){
		return this.keyName;
	}
	protected abstract void setMapper(Mapper<T> mapper);

	@Cacheable(value="common",key="#root.target.getKeyName()+'_list_'+#p0.offset+'_'+#p0.limit")  
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
