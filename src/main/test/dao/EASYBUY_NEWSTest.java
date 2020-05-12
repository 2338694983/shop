package dao;

import com.hr.entity.EASYBUY_NEWS;
import com.hr.service.EASYBUY_NEWSService;
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
 * @create: 2020-03-13 10:35
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EASYBUY_NEWSTest {
    @Autowired
    private EASYBUY_NEWSService easybuy_newsService;
    @Test
    public void test1(){
        ArrayList<EASYBUY_NEWS> easybuy_news = easybuy_newsService.selectAll1();
        for(EASYBUY_NEWS easybuy_new:easybuy_news){
            System.out.println(easybuy_new.getEN_TITLE());
        }
    }
    @Test
    public void test2(){
        EASYBUY_NEWS easybuy_news=new EASYBUY_NEWS();
        easybuy_news.setEN_TITLE("가가가가");
        easybuy_news.setEN_CONTENT("붙붙붙");
        int insert = easybuy_newsService.insert(easybuy_news);
        System.out.println(insert);


    }

}
