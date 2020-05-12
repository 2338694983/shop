package com.hr.controller;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.service.EASYBUY_USERService;
import com.hr.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-16 17:07
 **/
@Controller
@RequestMapping("/")
public class CheckController {
    @Autowired
    private EASYBUY_USERService easybuy_userService;
    @RequestMapping("/manage/checkName")
    public void CheckName(HttpServletRequest req,HttpServletResponse resp,String name)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        int  count= easybuy_userService.selectByName(name);
        PrintWriter out = resp.getWriter();
        if(count>0){
            out.print("false");
        }else{
            out.print("true");
        }
        out.close();
    }

    @RequestMapping("/checkusernum")
    public void CheckUserNum(HttpServletRequest req, HttpServletResponse resp,String num)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sysCode = (String)session.getAttribute("syscode");
        PrintWriter out  = resp.getWriter();
        if(sysCode.equals(num)){
            out.print("true");
        }else {
            out.print("false");
        }
        out.close();
    }
}
