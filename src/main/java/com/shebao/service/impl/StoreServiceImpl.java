package com.shebao.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shebao.model.Store;
import com.shebao.service.StoreService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private Mapper<Store> mapper;
	public List<Store> findAll(RowBounds rowBounds) {
		return mapper.selectByRowBounds(null, rowBounds);
	}
	public int findAllCount() {
		// TODO Auto-generated method stub
		return mapper.selectCount(null);
	}

}
