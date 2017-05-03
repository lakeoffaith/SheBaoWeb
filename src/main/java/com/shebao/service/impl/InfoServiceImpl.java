package com.shebao.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shebao.model.Info;
import com.shebao.model.Store;
import com.shebao.service.InfoService;
import com.shebao.service.StoreService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	private Mapper<Info> mapper;
	public List<Info> findAll(RowBounds rowBounds) {
		return mapper.selectByRowBounds(null, rowBounds);
	}
	public int findCount() {
		return mapper.selectCount(null);
	}

}
