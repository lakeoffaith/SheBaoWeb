package com.shebao.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.shebao.model.Info;
import com.shebao.model.Store;

public interface InfoService {
	public List<Info> findAll(RowBounds rowBounds);


	public int findCount();
}
