package com.ijoy.common.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.util.AjaxResult;
import com.ijoy.common.util.StringUtils;
import com.ijoy.service.IjoyCoreService;
import com.ijoy.service.Resource;
import com.ijoy.service.User;

@Controller
public class LoginController  extends BaseController{
	
	private static final int Client_Phone=0;
	private static final int Client_Web=1;
	@Autowired
	private IjoyCoreService ijoyCoreServiceApi;
	//登录 json
	
	@RequestMapping(value="/apiLogin/login",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult login(HttpServletRequest request,@RequestBody Map map){
		if(logger.isDebugEnabled()){
			logger.debug("进入 login^"+map.get("userName")+"^"+
					map.get("password")+"^"+map.get("type"));
		}
		String token;
		String userName=(String) map.get("userName");
		if(StringUtils.isBlank(userName))return new AjaxResult(false,"输入错误");
		String password=(String) map.get("password");
		if(StringUtils.isBlank(password))return new AjaxResult(false,"输入错误");
		String type=(String) map.get("type");
		
		if(StringUtils.isBlank(type))return new AjaxResult(false,"无效客户端");
		if(type.equals(String.valueOf(Client_Phone))){
			token=ijoyCoreServiceApi.loginByPhoneAndCode(userName, password);
		}else if(type.equals(String.valueOf(Client_Web))){
			token=ijoyCoreServiceApi.loginByUserNameAndPassword(userName, password);
		}else{
			return new AjaxResult(false,"无效客户端");
		}
		if(StringUtils.isBlank(token))return new AjaxResult(false,"用户名和密码错误");
		User user = ijoyCoreServiceApi.checkToken(token);
		AjaxResult result= new AjaxResult(true, token);
		result.setData(Arrays.asList(user));
		return result;
	}
	
	
	//注册 json
	@RequestMapping(value="/apiLogin/register",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult register(HttpServletRequest request,@RequestBody Map map){
		if(logger.isDebugEnabled()){
			logger.debug("进入 register^"+map.get("userName")+"^"+
					map.get("password")+"^"+map.get("type"));
		}
		Boolean flag=false;
		String userName=(String) map.get("userName");
		if(StringUtils.isBlank(userName))return new AjaxResult(false,"输入错误");
		String password=(String) map.get("password");
		if(StringUtils.isBlank(password))return new AjaxResult(false,"输入错误");
		String type=(String) map.get("type");
		if(StringUtils.isBlank(type))return new AjaxResult(false,"无效客户端");
		if(type.equals(String.valueOf(Client_Web))){
			flag=ijoyCoreServiceApi.registerByUserNameAndPassword(userName, password);
		}else{
			return new AjaxResult(false,"无效客户端");
		}
		if(flag)return new AjaxResult(true, "注册成功");
		
		return new AjaxResult(false, "注册失败");
	}
	@RequestMapping(value="/apiLogin/getCodeByPhone",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult getCodeByPhone(String phone){
		if(logger.isDebugEnabled()){
			logger.debug("进入 getCodeByPhone^"+phone);
		}
		if(phone==null && phone.length()==0)return new AjaxResult(false, "手机不能为空");
		if(!StringUtils.validePhone(phone))return new AjaxResult(false,"手机格式错误");
		String code = ijoyCoreServiceApi.getCodeByCellPhone(phone);
		if(code!=null && code.length()>0) return new AjaxResult(true,code);
		return new AjaxResult(false,"获取验证码失败");
	}
	
	@RequestMapping(value="/api/getUserByToken",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult getUserByToken(HttpServletRequest request){
		if(logger.isDebugEnabled()){
			logger.debug("进入 getUserByToken");
		}
		String token=request.getHeader("token");
		User user = ijoyCoreServiceApi.checkToken(token);
		if(user!=null)return new AjaxResult(true, Arrays.asList(user));
		return new AjaxResult(false,"无法获取用户");
	}
	
	@RequestMapping(value="/api/getMenuByUser",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult getMenuByUser(String userId,HttpServletRequest request){
		if(logger.isDebugEnabled()){
			logger.debug("进入 getMenuByUser^"+userId);
		}
		if(StringUtils.isBlank(userId))return new AjaxResult(false,"无法获取用户");
		List<Resource> menus=ijoyCoreServiceApi.getMenusByUserId(Integer.valueOf(userId));
		if(menus!=null)return new AjaxResult(true, menus);
		return new AjaxResult(false,"获取菜单失败");
	}
}
