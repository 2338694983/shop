package dao;

import com.hr.entity.EASYBUY_DD;
import com.hr.service.EASYBUY_DDService;
import com.hr.service.EASYBUY_DdanService;
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
 * @create: 2020-03-13 09:53
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EASYBUY_DDTest {
    @Autowired
    private EASYBUY_DDService easybuy_ddService;
    @Test
    public void test1(){
        ArrayList<EASYBUY_DD> easybuy_dds = easybuy_ddService.selectById(10);
        for (EASYBUY_DD easybuy_dd:easybuy_dds){
            System.out.println(easybuy_dd.getEP_NAME());
        }

    }
}
