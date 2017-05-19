package com.ijoy.common.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ijoy.service.IjoyCoreService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class WebServiceTest {
	@Autowired
	public IjoyCoreService ijoyCoreServiceApi;
	@Test
	public void ServiceTest(){
		String code = ijoyCoreServiceApi.getCodeByCellPhone("18228084571");
		Assert.assertTrue(code.length()==4);
	}
	
	@Test
	public void loginTest(){
		String token = ijoyCoreServiceApi.loginByPhoneAndCode("1234", "123");
		Assert.assertTrue(token==null);
	}
	
		
}
