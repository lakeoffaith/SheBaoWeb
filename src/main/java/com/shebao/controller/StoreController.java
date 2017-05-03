package com.shebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shebao.minSys.IjoyResource;
import com.shebao.minSys.util.AjaxResult;
import com.shebao.minSys.web.Query;
import com.shebao.service.StoreService;

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
