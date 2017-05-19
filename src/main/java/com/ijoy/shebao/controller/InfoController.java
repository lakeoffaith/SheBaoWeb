package com.ijoy.shebao.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.anonation.IjoyResource;
import com.ijoy.common.util.AjaxResult;
import com.ijoy.common.util.Query;
import com.ijoy.shebao.model.Info;
import com.ijoy.shebao.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoController {
	@Autowired
	private InfoService service;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	@IjoyResource("info:list")
	public AjaxResult findAll(Query query){
		System.out.println(query);
		return new AjaxResult(true,service.findAll(query.toRowBound()),service.findCount());
	}
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	@IjoyResource("info:get")
	public AjaxResult get(String id){
		
		return new AjaxResult(true,Arrays.asList(service.get(Integer.parseInt(id))));
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	@IjoyResource("info:save")
	public AjaxResult save(@RequestBody Info info){
		System.out.println(info);
		return new AjaxResult(true,Arrays.asList(service.insert(info)));
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	@IjoyResource("info:update")
	public AjaxResult update(@RequestBody Info info){
		System.out.println(info);
		return new AjaxResult(true,Arrays.asList(service.update(info)));
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	@ResponseBody
	@IjoyResource("info:delete")
	public AjaxResult delete(String id){
		try {
			service.delete(Integer.parseInt(id));
			return new AjaxResult(true,"删除成功");
		} catch (Exception e) {
			
		}
		return new AjaxResult(false,"删除失败");
		
	}
	
}
