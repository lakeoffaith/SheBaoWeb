package com.shebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shebao.minSys.IjoyResource;
import com.shebao.minSys.util.AjaxResult;
import com.shebao.minSys.web.Query;
import com.shebao.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoController {
	@Autowired
	private InfoService service;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	@IjoyResource("/info/list")
	public AjaxResult findAll(Query query){
		System.out.println(query);
		return new AjaxResult(true,service.findAll(query.toRowBound()),service.findCount());
	}
}
