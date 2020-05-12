package dao;

import com.hr.service.EASYBUY_DdanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: shop2
 * @description:购买记录
 * @author: Mr.L
 * @create: 2020-03-13 09:24
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EASYBUY_DdanTest {
    @Autowired
    private EASYBUY_DdanService easybuy_ddanService;
    @Test
    public void test1(){
        System.out.println(easybuy_ddanService.selectById("15927306638"));
    }
}

