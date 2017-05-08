package com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shebao.mapper.StoreMapper;
import com.shebao.minSys.util.api.DataUtil;
import com.shebao.minSys.util.api.ImageUtil;
import com.shebao.model.Store;

import tk.mybatis.mapper.common.Mapper;

public class Hello {
	public static void main(String[] args) throws Exception{
		
		String path="E://help//work//sysSheBao//src//main//webapp//"+"image";
		 ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		  Mapper<Store> mapper=(Mapper<Store>) ac.getBean(StoreMapper.class);
	      String url="http://www.tngou.net/api/Store/list?rows=200";
	      List<Store> list = DataUtil.list(url);
	      for (Store s : list) {
	    	  String pathTwo=path+s.getImg().replace("/", "\\");
    	  ImageUtil.down("http://tnfs.tngou.net/image"+s.getImg(), path+s.getImg().replace("/", "\\"));
	    	  mapper.insert(s);
		}
	}
}
