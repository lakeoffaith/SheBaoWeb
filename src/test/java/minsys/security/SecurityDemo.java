package minsys.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class SecurityDemo {
		
		
		//@Test
		public void login() throws Exception{
			Factory<org.apache.shiro.mgt.SecurityManager> factory =  
		            new IniSecurityManagerFactory("classpath:shiro.ini"); 
			org.apache.shiro.mgt.SecurityManager securityManager=factory.getInstance();
		    SecurityUtils.setSecurityManager(securityManager);  
		    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
		    Subject subject = SecurityUtils.getSubject();  
		    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
		    System.out.println(token);
		    try {  
		        //4、登录，即身份验证  
		        subject.login(token);  
		    } catch (AuthenticationException e) {  
		        //5、身份验证失败  
		    }  
		  
		    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
		  
		    //6、退出  
		    subject.logout();  
		}
		
		
		//real  test
		@Autowired
		private SecurityManager manager;
		@Test
		public void loginRealmTest() throws Exception{
			
		    SecurityUtils.setSecurityManager(manager);  
		    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
		    Subject subject = SecurityUtils.getSubject();  
		    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
		    try {  
		        //4、登录，即身份验证  
		        subject.login(token);  
		    } catch (AuthenticationException e) {  
		        //5、身份验证失败  
		    }  
		  
		    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
		  
		    //6、退出  
		    subject.logout();  
		}
		
}
