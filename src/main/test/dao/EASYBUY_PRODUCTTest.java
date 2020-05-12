package dao;

import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.impl.EASYBUY_PRODUCTServiceImpl;
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
 * @create: 2020-03-14 08:54
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EASYBUY_PRODUCTTest {
    @Autowired
    private EASYBUY_PRODUCTService easybuy_productService;
    @Test
    public void test1(){
        ArrayList<EASYBUY_PRODUCT> easybuy_products = easybuy_productService.selectAll();
        System.out.println(easybuy_products);
    }
    @Test
    public void test2(){
        ArrayList<EASYBUY_PRODUCT> easybuy_products = easybuy_productService.selectAllByName("啦");
        System.out.println(easybuy_products);
    }
    @Test
    public void test3(){
        EASYBUY_PRODUCT easybuy_product = easybuy_productService.selectById(2);
        System.out.println(easybuy_product);
    }
    @Test
    public void test4(){
        ArrayList<EASYBUY_PRODUCT> easybuy_products = easybuy_productService.selectAllByT();
        for (EASYBUY_PRODUCT easybuy_product:easybuy_products) {
            System.out.println(easybuy_products);
        }
    }
}
