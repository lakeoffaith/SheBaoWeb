package com.shebao.minSys.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

public class MobileTokenAuthentication extends AuthenticationFilter {
	public static final String TOKEN = "token";
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		System.out.println("进入token 判断");
		String token=request.getParameter("token");
		Subject subject = getSubject(request,response);
		Session session = subject.getSession();
		if("李振纲".equals(session.getAttribute(token))){
			return true;
		}
		return false;
	}
	
	
}
