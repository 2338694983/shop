package dao;

import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-13 16:53
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EASYBUY_PRODUCT_CATEGORYTest {
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYService easybuy_product_categoryService;
    @Test
    public void test1(){
        System.out.println(easybuy_product_categoryService.selectAll());
    }
    @Test
    public void test2(){
        System.out.println(easybuy_product_categoryService.selectFather());
    }
}
