package shebao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shebao.model.Shop;

import tk.mybatis.mapper.common.Mapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class ShopTest {
		
		@Autowired
		private Mapper<Shop> mapper;
		
		/*@Test
		public void getAllTest(){
			List list=mapper.select(null);
			System.out.println(list);
		}*/
		@Test
		public void pageTest(){
			PageHelper.startPage(1, 10);
			List<Shop> list=mapper.select(null);
			System.out.println(list.get(0));
			
		}
}
