package com.shebao.minSys.shiro.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		logger.info("进入授权");
		System.out.println("开始授权");
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

		info.addStringPermission("sys:manager");

		info.addStringPermission("user");

		System.out.println("开始授权");

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		
		logger.info("进入验证登录");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String tokenCode=(String) token.getPrincipal();
		
		//存放session.
		System.out.println("验证登录"+tokenCode);
		
		return new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),getName());
	}

}
