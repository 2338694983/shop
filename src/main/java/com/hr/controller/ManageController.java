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
import java.util.ArrayList;
import java.util.Date;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 11:07
 **/
@Controller
@RequestMapping("/")
public class ManageController {
    @Autowired
    private EASYBUY_COMMENTService easybuy_commentService;
    @RequestMapping("/manage/ChaManage")
    public void ChaManage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<EASYBUY_COMMENT> list = easybuy_commentService.selectAll();
        //寄包裹
        req.setAttribute("list", list);
        //转发
        req.getRequestDispatcher("guestbook.jsp").forward(req,resp);
    }
    @RequestMapping("/manage/DelManage")
    public void DelManage(HttpServletRequest request, HttpServletResponse response,String id)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int num=easybuy_commentService.del(Integer.parseInt(id));
        if(num>0){
            response.sendRedirect("manage-result.jsp");
        }else{
            response.getWriter().print("<script>alert('删除失败!');location.href='SelManage'<script>");
        }
    }
    @RequestMapping("/manage/SelManage")
    public void SelManage(HttpServletRequest req, HttpServletResponse resp,@RequestParam(value = "page",required = false) String spage)
            throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int page=1; //当前页数
        int pagesize=6;//每页行数
        if(spage!=null){ //如果页面上传递了页数,将当前页数改变掉
            page=Integer.parseInt(spage);

        }
        //查出总页数
        ArrayList<EASYBUY_COMMENT> list=easybuy_commentService.selPage(page, pagesize);
        int max_page=easybuy_commentService.getMax(pagesize);
        if(list.size()>0&&max_page>0){
            req.setAttribute("list", list);
            //把总页数传递给guestbook.jsp 使用
            req.setAttribute("max_page", max_page);
            //把当前页数传递给guestbook.jsp使用
            req.setAttribute("page", page);
            // 跳
            req.getRequestDispatcher("guestbook.jsp").forward(req,resp);
        }else{
            resp.getWriter().print("还没有留言信息哦！");
        }
    }
    @RequestMapping("/manage/UpdateManage")
    public void UpdateManage(HttpServletRequest request, HttpServletResponse response,String id)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        EASYBUY_COMMENT comment=easybuy_commentService.selOne(Integer.parseInt(id));
        if(comment!=null){
            request.setAttribute("list",comment);
            request.getRequestDispatcher("guestbook-modify.jsp").forward(request, response);
        }else{
            response.getWriter().print("<script>alert('查询失败！');history.back();</script>");
        }
    }
    @RequestMapping("/manage/UpManage")
    public void UpManage(HttpServletRequest request, HttpServletResponse response,String orderId,String name,String replyContent,String Content)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Date date=new Date();
        System.out.println(Content);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String replyTime=sdf.format(date);
        EASYBUY_COMMENT comment=new EASYBUY_COMMENT(Integer.parseInt(orderId),Content,replyTime,replyContent,replyTime,name);

        //System.out.println(id+"--"+content+"--"+replyTime+"--"+replyContent+"--"+name);
        comment.setEC_ID(Integer.parseInt(orderId));
        int num=easybuy_commentService.update(comment);
        if(num>0){
            response.sendRedirect("manage-result.jsp");
        }else{
            response.getWriter().print("<script>alert('更新失败！');history.back();</script>");
        }
    }
}
