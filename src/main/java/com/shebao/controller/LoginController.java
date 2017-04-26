package com.shebao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ijoy.service.ILoginInfoService;
import com.ijoy.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private ILoginInfoService loginInfoClient;
	
	@Autowired
	private IUserService userWsClient;
	@RequestMapping(value="/apiLogin/getCodeByPhone",method=RequestMethod.GET)
	public ResponseEntity<String> getCodeByPhone(String phone){
		System.out.println("进入");
		String code = loginInfoClient.getCodeByCellPhone(phone);
		 return new ResponseEntity<String>(code, HttpStatus.OK); 
	}
	@RequestMapping(value="/apiLogin/getTokenByPhoneAndCode",method=RequestMethod.GET)
	public ResponseEntity<String> getTokenByPhoneAndCode(String phone,String code){
		String result = loginInfoClient.loginByPhoneAndCode(phone, code);
		
		//不存在
		return  new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/main",method=RequestMethod.GET)
	public ResponseEntity<String> getTokenByPhoneAndCode(){
		return  new ResponseEntity<String>("success get main",HttpStatus.CONFLICT);
	}
	
	
	
	

}
