package com.ijoy.shebao.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.service.impl.BaseServiceImpl;
import com.ijoy.shebao.model.Info;
import com.ijoy.shebao.model.Store;
import com.ijoy.shebao.service.StoreService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {
	public Mapper<Store> mapper;
    //这句必须要加上。不然会报异常，因为在实际掉用的时候不是BaseDao调用  
	@Autowired
	@Override
	protected void setMapper(Mapper<Store> mapper) {
		super.mapper=mapper;
		this.mapper=mapper;
	}
	public List<Store> findAll(RowBounds rowBounds) {
		return mapper.selectByRowBounds(null, rowBounds);
	}
	public int findAllCount() {
		// TODO Auto-generated method stub
		return mapper.selectCount(null);
	}

}
