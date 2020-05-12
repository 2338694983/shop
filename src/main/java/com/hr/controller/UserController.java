package com.hr.controller;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.service.EASYBUY_USERService;
import com.hr.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 10:28
 **/
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private EASYBUY_USERService easybuy_userService;
    @RequestMapping("/manage/useradd")
    public void Useradd(HttpServletRequest req, HttpServletResponse resp,
                        @RequestParam("userName")String username,
                        @RequestParam("name")String name,
                        @RequestParam("passWord")String pwd,
                        @RequestParam("sex")String sex,
                        @RequestParam("birthday")String year,
                        @RequestParam("email")String email,
                        @RequestParam("mobile")String mobile,
                        @RequestParam("address")String address
                        )
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");

        EASYBUY_USER u=new EASYBUY_USER(username, name, pwd, sex, year, null, email, mobile, address, 1);
        int count= easybuy_userService.insert(u);
        PrintWriter out=resp.getWriter();
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            out.write("<script>");
            out.write("alert('���ʧ��');");
            out.write("location.href='user-add.jsp'");
            out.write("</script>");
            out.close();
        }
    }
    @RequestMapping("/manage/userdel")
    public void UserDel(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        int count=easybuy_userService.del(id);
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            out.write("<script>");
            out.write("alert('删除失败');");
            out.write("location.href='user.jsp'");
            out.write("</script>");
            out.close();
        }
    }
    @RequestMapping("/manage/userdoupdate")
    public void UserDoupdate(HttpServletRequest req, HttpServletResponse resp,
                             @RequestParam("userName")String username,
                             @RequestParam("name")String name,
                             @RequestParam("passWord")String pwd,
                             @RequestParam("sex")String sex,
                             @RequestParam("birthday")String birthday,
                             @RequestParam("email")String email,
                             @RequestParam("mobile")String mobile,
                             @RequestParam("address")String address)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        String userStatus=req.getParameter("userStatus");
        int status = 1;
        if(userStatus != null && !"".equals(userStatus)){
            status = Integer.parseInt(userStatus);
        }
        EASYBUY_USER user=new EASYBUY_USER(username, name, pwd, sex, birthday, null, email, mobile, address, status);
        int count=easybuy_userService.update(user);
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            PrintWriter out=resp.getWriter();
            out.print("<script>");
            out.print("alert('修改失败');");
            out.print("location.href='user'");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/usernamecheck")
    public void  UsernameCheck(HttpServletRequest req, HttpServletResponse resp,String name)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        int  count=easybuy_userService.selectByName(name);
        PrintWriter out = resp.getWriter();
        if(count>0){
            out.print("false");
        }else{
            out.print("true");
        }
        out.close();
    }
    @RequestMapping("/usernum")
    public void UserNum(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int width=120;
        int height=60;
        BufferedImage img=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g=img.createGraphics();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.YELLOW);
        Random rand=new Random();
        for (int i = 0; i < 15; i++) {
            int x1=rand.nextInt(width);
            int y1=rand.nextInt(width);
            int x2=rand.nextInt(width);
            int y2=rand.nextInt(width);
            g.drawLine(x1, y1, x2, y2);
        }

        Font f=new Font("Times New Roman",Font.BOLD,50);
        g.setFont(f);
        int red=0,green=0,blue=0;
        String code="";

        for (int i = 0; i < 4; i++) {
            red=rand.nextInt(255);
            green=rand.nextInt(255);
            blue=rand.nextInt(255);

            Color c=new Color(red,green,blue);
            g.setColor(c);
            int num=rand.nextInt(10);
            code+=num;
            g.drawString(num+"", i*20+20, 49);
        }

        HttpSession session=req.getSession();
        session.setAttribute("syscode", code);

        ServletOutputStream out=resp.getOutputStream();
        ImageIO.write(img, "jpg", out);
    }
    @RequestMapping("/manage/user")
    public void User(HttpServletRequest req, HttpServletResponse resp,String cp)
            throws ServletException, IOException {
        int cpage=1;
        int count=15;
        if(cp!=null){
            cpage=Integer.parseInt(cp);
        }
        int tpage=easybuy_userService.totalPage(count);
        ArrayList<EASYBUY_USER> list=easybuy_userService.selectAll(cpage,count);
        req.setAttribute("userlist", list);
        req.setAttribute("cpage", cpage);
        req.setAttribute("tpage", tpage);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
    @RequestMapping("/manage/userupdate")
    public void UserUpdate(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        EASYBUY_USER user=easybuy_userService.selectById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("user-modify.jsp").forward(req, resp);
    }
    @RequestMapping("/login")
    public void Login(HttpServletRequest req, HttpServletResponse resp,
                      @RequestParam("userName") String username,
                      @RequestParam("passWord") String passWord,
                      @RequestParam("veryCode") String veryCode
                      )
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        //获得系统生成的验证码
        String sysCode = (String)session.getAttribute("syscode");
        int count=easybuy_userService.selectByNM(username, passWord);
        EASYBUY_USER user=easybuy_userService.selectAdmin(username, passWord);
        if(sysCode.equals(veryCode)){
            if(count>0){
                session.setAttribute("name", user);
                if(user.getEU_STATUS()==2){
                    resp.sendRedirect("manage/index.jsp");
                }else{
                    resp.sendRedirect("indexSelect");
                }
            }else{
                PrintWriter out = resp.getWriter();
                out.print("<script>");
                out.print("alert('用户名或密码错误');");
                out.print("location.href='login.jsp';");
                out.print("</script>");
                out.close();
            }
        }else{
            PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('验证码错误');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/register")
    public void RegisterIn(HttpServletRequest req, HttpServletResponse resp,
                           @RequestParam("userName")String username,
                           @RequestParam("name")String name,
                           @RequestParam("rePassWord")String  rePassWord,
                           @RequestParam("sex")String sex,
                           @RequestParam("birthday")String year,
                           @RequestParam("email")String email,
                           @RequestParam("mobile")String mobile,
                           @RequestParam("address")String address,
                           @RequestParam("veryCode")String veryCode)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String sysCode = (String) session.getAttribute("syscode");
        EASYBUY_USER u = new EASYBUY_USER(username, name, rePassWord, sex, year, null, email, mobile, address, 1);
        int count = easybuy_userService.insert(u);
        PrintWriter out = resp.getWriter();
        if (sysCode.equals(veryCode)) {
            if (count > 0) {
                resp.sendRedirect("reg-result.jsp");
            } else {
                out.write("<script>");
                out.write("alert('register error');");
                out.write("location.href='register.jsp'");
                out.write("</script>");
                out.close();
            }
        }
    }



}
