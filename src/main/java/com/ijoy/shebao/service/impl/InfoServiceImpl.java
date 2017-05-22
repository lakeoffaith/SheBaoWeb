package com.ijoy.shebao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ijoy.common.service.impl.BaseServiceImpl;
import com.ijoy.shebao.model.Info;
import com.ijoy.shebao.service.InfoService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {
	public Mapper<Info> mapper;
	
    //这句必须要加上。不然会报异常，因为在实际掉用的时候不是BaseDao调用  
	@Autowired
	@Override
	protected void setMapper(Mapper<Info> mapper) {
		super.mapper=mapper;
		super.keyName="info";
		this.mapper=mapper;
	}
	
	@Transactional
	public void insertBatch() {
		Info info=new Info();
		info.setTitle("test1");
		mapper.insert(info);
		System.out.println(1/0);
		Info info2=new Info();
		info2.setTitle("test2");
		mapper.insert(info2);
	}

	
}
