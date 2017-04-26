package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.CommentService;

public class Hello {
	public static void main(String[] args){
		 ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		  System.out.println(ac.getBean("redisTemplate"));
	      
	       
	}
}
