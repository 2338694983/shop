package dao;

import com.hr.entity.EASYBUY_ORDER;
import com.hr.service.EASYBUY_ORDERService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 14:45
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EASYBUY_ORDERTest {
    @Autowired
    private EASYBUY_ORDERService easybuy_orderService;
    @Test
    public void test1(){
        System.out.println(easybuy_orderService.selectAll1());
    }
    @Test
    public void test2(){
        int i = easybuy_orderService.totalPage(2, "10", "啦");
        System.out.println(i);
    }
    @Test
    public void test3(){
        ArrayList<EASYBUY_ORDER> easybuy_orders = easybuy_orderService.selectAll(5, 2, "10", "啦");
        for(EASYBUY_ORDER easybuy_order:easybuy_orders) {
            System.out.println(easybuy_order);
        }
    }
}
