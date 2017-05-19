package com.ijoy.shebao.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.ijoy.shebao.model.Store;

public interface StoreService {
	public List<Store> findAll(RowBounds rowBounds);

	public int findAllCount();

}
