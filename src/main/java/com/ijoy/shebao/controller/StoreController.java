package com.ijoy.shebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.anonation.IjoyResource;
import com.ijoy.common.util.AjaxResult;
import com.ijoy.common.util.Query;
import com.ijoy.shebao.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreService service;
	
	@RequestMapping("/list")
	@ResponseBody
	@IjoyResource("/store/list")
	public AjaxResult findAll(Query query){
		System.out.println(query);
		return new AjaxResult(true,service.findAll(query.toRowBound()),service.findAllCount());
	}
}
