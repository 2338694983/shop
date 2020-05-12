package com.hr.controller;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;
import com.hr.service.EASYBUY_COMMENTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 10:51
 **/
@Controller
@RequestMapping("/")
public class GueController {
    @Autowired
    private EASYBUY_COMMENTService easybuy_commentService;
    @RequestMapping("/GueServlet")
    public void Gue(HttpServletRequest request, HttpServletResponse response,String guestName,String guestContent)
            throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //2.取值 ----
        //把date转为String
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(date).toString();
        //System.out.println(guestContent);
        EASYBUY_COMMENT comment=new EASYBUY_COMMENT(0,guestContent,time,"",null,guestName);
        int num= easybuy_commentService.insert(comment);
        if(num>0){
            response.sendRedirect("SelallServlet");
        }else{
            response.getWriter().print("<script>alert('添加失败！');history.back();</script>");

        }

    }

}
