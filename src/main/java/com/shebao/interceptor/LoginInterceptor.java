package com.shebao.interceptor;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ijoy.service.IUserService;
import com.ijoy.service.Resource;
import com.shebao.minSys.util.Base64Util;
import com.shebao.util.CacheUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter  {
	@Autowired
	private IUserService userService;
	@Autowired(required=true)
	protected CacheUtil cacheUtil;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		/*System.out.println("进入handle");
		String requestUrl=request.getRequestURI().replaceAll(request.getContextPath(), "");
		System.out.println("requestUrl="+requestUrl);
		if(requestUrl.contains("login") || requestUrl.contains("Login"))return true;
		//检查登录
		String token=request.getParameter("token");
		if(token==null) return false;
		String decode = Base64Util.decode(token);
		int userId=Integer.parseInt(decode.split(":")[0]);
		Boolean flag=cacheUtil.checkUserIdAndToken(userId, token);
		if(!flag)return false;
		//检查权限
		List<Resource> resource = userService.getMenusByUserId(1);
		
		for (Resource r : resource) {
			System.out.println(r.getUrl());
			if(requestUrl!=null && requestUrl.equals(r.getUrl())){
				return true;
			}
		}*/
		 return true;
		//return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("退出handle");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	

}
