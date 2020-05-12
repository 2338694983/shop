package dao;

import com.hr.service.EASYBUY_USERService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-14 14:59
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EASYBUY_USERDaoTest {
    @Autowired
    private EASYBUY_USERService easybuy_userService;
    @Test
    public void test1(){
        System.out.println(easybuy_userService.selectAll());
    }
    @Test
    public void test2(){
        System.out.println(easybuy_userService.totalPage(2));
    }
    @Test
    public void test3(){
        System.out.println(easybuy_userService.selectByNM("15927306638","12345678"));
    }
}
