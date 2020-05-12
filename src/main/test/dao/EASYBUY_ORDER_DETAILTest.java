package dao;

import com.hr.entity.EASYBUY_DD;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.service.EASYBUY_DDService;
import com.hr.service.EASYBUY_ORDER_DETAILService;
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
 * @create: 2020-03-13 10:07
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EASYBUY_ORDER_DETAILTest {
    @Autowired
    private EASYBUY_ORDER_DETAILService easybuy_order_detailService;
    @Test
    public void test1(){
        ArrayList<EASYBUY_ORDER_DETAIL> easybuy_order_details = easybuy_order_detailService.selectAll();
        for (EASYBUY_ORDER_DETAIL easybuy_order_detail:easybuy_order_details){
            System.out.println(easybuy_order_detail.getEO_ID());
        }

    }
}
