package dao;

import com.hr.entity.EASYBUY_COMMENT;
import com.hr.service.EASYBUY_COMMENTService;
import com.hr.service.impl.EASYBUY_COMMENTServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.ArrayList;

/**
 * @program: shop
 * @description:
 * @author: Mr.L
 * @create: 2020-03-11 14:21
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EASYBUY_COMMENTTest {
    @Autowired
    private EASYBUY_COMMENTService service;
    @Test
    public void ecTest1(){
        ArrayList<com.hr.entity.EASYBUY_COMMENT> easybuy_comments = service.selectAll();
        for(com.hr.entity.EASYBUY_COMMENT ec:easybuy_comments){
            System.out.println(ec.getEC_NICK_NAME());
        }
    }
    @Test
    public void ecTest2(){
        com.hr.entity.EASYBUY_COMMENT easybuy_comment = service.selectById(7);
        System.out.println(easybuy_comment);
    }
    @Test
    public void ecTest3() {
        com.hr.entity.EASYBUY_COMMENT easybuy_comment = new com.hr.entity.EASYBUY_COMMENT();
        easybuy_comment.setEC_ID(6);
        easybuy_comment.setEC_CONTENT("啊啊啊啊");
        easybuy_comment.setEC_CREATE_TIME("2018-12-19 14:30:42");
        easybuy_comment.setEC_REPLY("enen");
        easybuy_comment.setEC_REPLY_TIME("2018-12-19 14:30:45");
        easybuy_comment.setEC_NICK_NAME("张三");
        service.insert(easybuy_comment);
    }
    @Test
    public void ecTest4(){
        com.hr.entity.EASYBUY_COMMENT easybuy_comment = new com.hr.entity.EASYBUY_COMMENT();
        easybuy_comment.setEC_ID(15);
        easybuy_comment.setEC_CONTENT("啦啦啦");
        easybuy_comment.setEC_CREATE_TIME("2018-12-19 14:30:42");
        easybuy_comment.setEC_REPLY("enen");
        easybuy_comment.setEC_REPLY_TIME("2018-12-19 14:30:45");
        easybuy_comment.setEC_NICK_NAME("李四");
        service.update(easybuy_comment);
    }
    @Test
    public void ecTest5(){
        service.del(15);
    }
    @Test
    public void ecTest6(){
        ArrayList<com.hr.entity.EASYBUY_COMMENT> easybuy_comments = service.selPage(1, 5);
        for(com.hr.entity.EASYBUY_COMMENT ec:easybuy_comments){
            System.out.println(ec.getEC_NICK_NAME());
        }
    }
    @Test
    public void ecTest7(){
        com.hr.entity.EASYBUY_COMMENT easybuy_comment = service.selOne(7);
        System.out.println(easybuy_comment);
    }
    @Test
    public void ecTest8(){
        com.hr.entity.EASYBUY_COMMENT easybuy_comment = new com.hr.entity.EASYBUY_COMMENT();
        easybuy_comment.setEC_ID(6);
        easybuy_comment.setEC_CONTENT("啊啊啊啊");
        easybuy_comment.setEC_CREATE_TIME("2018-12-19 14:30:42");
        easybuy_comment.setEC_REPLY("enen");
        easybuy_comment.setEC_REPLY_TIME("2018-12-19 14:30:45");
        easybuy_comment.setEC_NICK_NAME("张三");
        int u = service.u(easybuy_comment);
        System.out.println(u);
    }
    @Test
    public void ecTest9(){
        int max = service.getMax(5);
        System.out.println(max);
    }
    @Test
    public void ecTest10(){
        ArrayList<com.hr.entity.EASYBUY_COMMENT> easybuy_comments = service.selPages("张三", 2, 3);
        for(com.hr.entity.EASYBUY_COMMENT ec:easybuy_comments){
            System.out.println(ec.getEC_NICK_NAME());
        }
    }
}
