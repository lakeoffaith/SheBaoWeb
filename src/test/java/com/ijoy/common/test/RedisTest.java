package com.ijoy.common.test;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ijoy.shebao.model.Info;
import com.ijoy.shebao.service.InfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class RedisTest {
	@Autowired
	private InfoService service;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Test
	public void listTest(){
		System.out.println(redisTemplate);
		RowBounds rowBounds=new RowBounds(0, 10);
		List<Info> list = service.findAll(rowBounds);
		System.out.println(list.size());
	}

}
