package test1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-15 14:09
 **/
public class test1_1 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object bean = ac.getBean("EASYBUY_PRODUCT_CATEGORYServiceImpl");
        System.out.println(bean);
    }
}
