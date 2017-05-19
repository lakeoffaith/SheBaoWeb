package com.ijoy.shebao.test;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ijoy.shebao.service.InfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class InfoTest {
		
		@Autowired
		private InfoService service;
		@Test
		public void getAllTest(){
			List list=service.findAll(new RowBounds());
			Assert.assertTrue(list.size()>0);
		}
		
		//事务处理
		
		public void transactionText(){
			service.insertBatch();
		}
}
