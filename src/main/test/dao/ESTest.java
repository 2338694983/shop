package dao;

import com.hr.service.ESService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 15:33
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ESTest {
    @Autowired
    private ESService esService;
    @Test
    public void test1(){
        System.out.println(esService.getSequenceId());
    }
    @Test
    public void test2(){
        System.out.println(esService.getShop("11"));
    }
}
