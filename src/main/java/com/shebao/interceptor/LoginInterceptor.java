package com.shebao.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ijoy.service.IUserService;
import com.ijoy.service.Resource;

public class LoginInterceptor extends HandlerInterceptorAdapter  {
	@Autowired
	private IUserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入handle");
		String requestUrl=request.getRequestURI().replaceAll(request.getContextPath(), "");
		System.out.println("requestUrl="+requestUrl);
		if(requestUrl.contains("login") || requestUrl.contains("Login"))return true;
		List<Resource> resource = userService.getMenusByUserId(1);
		
		for (Resource r : resource) {
			System.out.println(r.getUrl());
			if(requestUrl!=null && requestUrl.equals(r.getUrl())){
				return true;
			}
		}
		 return false;
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
