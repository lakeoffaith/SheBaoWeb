package com.shebao.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.shebao.model.Store;

public interface StoreService {
	public List<Store> findAll(RowBounds rowBounds);

	public int findAllCount();

}
