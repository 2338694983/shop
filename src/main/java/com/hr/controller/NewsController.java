package com.hr.controller;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.service.EASYBUY_NEWSService;
import com.hr.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 09:28
 **/
@Controller
@RequestMapping("/")
public class NewsController {
    @Autowired
    private EASYBUY_NEWSService easybuy_newsService;
    @RequestMapping("/manage/delnews")
    public void NewsDel(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        int count= easybuy_newsService.del(Integer.parseInt(id));
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.print("<script>");
            out.print("alert('删除失败');");
            out.print("location.href='newsselect'");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/manage/doupnews")
    public void NewsDou(HttpServletRequest req, HttpServletResponse resp,String id,String title,String content)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        EASYBUY_NEWS n=new EASYBUY_NEWS(Integer.parseInt(id), title, content, null);
        int count=easybuy_newsService.update(n);
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.print("<script>");
            out.print("alert('修改失败');");
            out.print("location.href='newsselect'");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/manage/insertnews")
    public void NewsIns(HttpServletRequest req, HttpServletResponse resp,String title,String content)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        EASYBUY_NEWS news=new EASYBUY_NEWS(0, title, content, null);
        int count =easybuy_newsService.insert(news);
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.print("<script>");
            out.print("alert('添加失败');");
            out.print("location.href='news-add.jsp'");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/manage/newsselect")
    public void Newsselect(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int cpage=1;
        int count=10;
        String cp=req.getParameter("cp");
        if(cp!=null){
            cpage=Integer.parseInt(cp);
        }
        int tpage=easybuy_newsService.totalPage(count);
        ArrayList<EASYBUY_NEWS> newslist=easybuy_newsService.selectAll(cpage,count);
        req.setAttribute("newslist", newslist);
        req.setAttribute("cpage", cpage);
        req.setAttribute("tpage", tpage);
        req.getRequestDispatcher("news.jsp").forward(req, resp);
    }
    @RequestMapping("/newsSelect2")
    public void NewsSelect2(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EASYBUY_NEWS n = null;
        if(id!=null){
            n = easybuy_newsService.selectById(Integer.parseInt(id));
        }
        req.setAttribute("n", n);
        ArrayList<EASYBUY_NEWS> nlist = easybuy_newsService.selectAll1();
        req.setAttribute("nlist", nlist);
        req.getRequestDispatcher("news-view.jsp").forward(req, resp);
    }
    @RequestMapping("/manage/upnews")
    public void NewsUpd(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EASYBUY_NEWS news=easybuy_newsService.selectById(Integer.parseInt(id));
        req.setAttribute("news", news);
        req.getRequestDispatcher("news-modify.jsp").forward(req, resp);
    }

}
