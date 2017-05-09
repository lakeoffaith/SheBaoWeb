package com.shebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.service.ILoginInfoService;
import com.ijoy.service.IUserService;
import com.ijoy.service.User;
import com.shebao.minSys.util.AjaxResult;

@Controller
public class LoginController {
	@Autowired
	private ILoginInfoService loginInfoClient;
	
	@Autowired
	private IUserService userWsClient;
	
	@RequestMapping(value="/apiLogin/getCodeByPhone",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult getCodeByPhone(String phone){
		System.out.println("进入");
		String code = loginInfoClient.getCodeByCellPhone(phone);
		return new AjaxResult(true, code);
	}
	@RequestMapping(value="/apiLogin/getTokenByPhoneAndCode",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult getTokenByPhoneAndCode(String phone,String code){
		String result = loginInfoClient.loginByPhoneAndCode(phone, code);
		
		//不存在
		return new AjaxResult(true, result);
	}
	
	@RequestMapping(value="/apiLogin/getUserByToken",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult getUserByToken(String token){
		User user = loginInfoClient.checkToken(token);
		if(user!=null)return new AjaxResult(true, user);
		return new AjaxResult(false,"无法获取用户");
	}
	
	
	
	

}
