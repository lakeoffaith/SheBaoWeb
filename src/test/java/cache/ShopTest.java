package cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shebao.service.EhCacheTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class ShopTest {
		
		@Autowired
		private EhCacheTestService service;
		
		@Test
		public void pageTest() throws Exception{
			String timestamp = service.getTimestamp("nihao");
			System.out.println(timestamp);
			Thread.sleep(2000);
			String timestamp2=service.getTimestamp("nihao");
			System.out.println("2秒后调用："+timestamp2);
			
			Thread.sleep(11000);
			String timestamp3=service.getTimestamp("nihao");
			System.out.println("14秒后调用："+timestamp3);
			
			
		}
}
