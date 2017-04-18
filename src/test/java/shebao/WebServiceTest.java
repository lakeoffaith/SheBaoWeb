package shebao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ijoy.service.ILoginInfoService;
import com.ijoy.service.IUserService;
import com.ijoy.service.Resource;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class WebServiceTest {
	
	/*@Test
	public void ServiceTest(){
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ILoginInfoService.class);
        factory.setAddress("http://192.168.0.107:8889/core/service/LoginInfo");
        
        ILoginInfoService service = (ILoginInfoService) factory.create();
        
        String phone = service.getCodeByCellPhone("123");
        System.out.println(phone);
	}*/
	@Autowired
	private IUserService userWsClient;
	
	@Autowired
	private ILoginInfoService loginInfoClient;
	@Test
	public void ServiceInterceptorTest(){
        
        List<Resource> phone = userWsClient.getButtonsByUserId(1);
        System.out.println(phone);
        System.out.println(phone.get(0).getUrl());
	}
	
	@Test
	public void LoginInfoTest(){
        
		String code = loginInfoClient.getCodeByCellPhone("123");
		System.out.println("code:"+code);//6603

		String token = loginInfoClient.loginByPhoneAndCode("123", code);
		System.out.println("token:"+token);
		boolean flag = loginInfoClient.checkToken(token);
		System.out.println("登录是否成功："+flag);
	}
		
}
