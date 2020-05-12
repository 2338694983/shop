package com.hr.controller;

import com.hr.dao.EASYBUY_DDDao;
import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.entity.EASYBUY_DD;
import com.hr.entity.EASYBUY_ORDER;
import com.hr.service.EASYBUY_DDService;
import com.hr.service.EASYBUY_ORDERService;
import com.hr.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 09:37
 **/
@Controller
@RequestMapping("/")
public class OrderController {
    @Autowired
    private EASYBUY_ORDERService easybuy_orderService;
    @Autowired
    private  EASYBUY_DDService easybuy_ddService;
    @RequestMapping("/manage/delorder")
    public void OderDel(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        int count= easybuy_orderService.del(Integer.parseInt(id));
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.print("<srcipt>");
            out.print("alert('删除失败');");
            out.print("location.href='ordersel'");
            out.print("</srcipt>");
        }
    }
    @RequestMapping("/manage/douporder")
    public void OrderDoU(HttpServletRequest req, HttpServletResponse resp,String orderId,String name,String addres,String cost,String tatus)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        EASYBUY_ORDER order=new EASYBUY_ORDER(Integer.parseInt(orderId), "", name, addres, "", Integer.parseInt(cost), Integer.parseInt(tatus), 1);
        int count=easybuy_orderService.update(order);
        if(count>0){
            resp.sendRedirect("manage-result.jsp");
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.print("<script>");
            out.print("alert('�޸�ʧ��');");
            out.print("location.href='ordersel'");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/manage/ordersel")
    public void OrderSel(HttpServletRequest req, HttpServletResponse resp, @RequestParam(value = "cp",required = false) String cp, @RequestParam(value = "orderId",required = false) String id, @RequestParam(required = false) String userName)
            throws ServletException, IOException {
        int cpage=1;
        int count=10;
        EncodeUtil.encode(req);
        userName =userName==null ? "" :userName;
        if(cp!=null){
            cpage=Integer.parseInt(cp);
        }
        int tpage=easybuy_orderService.totalPage(count,id,userName);
        ArrayList<EASYBUY_ORDER> order=easybuy_orderService.selectAll(cpage,count,id,userName);
        req.setAttribute("order", order);
        req.setAttribute("cpage", cpage);
        req.setAttribute("tpage", tpage);
        req.setAttribute("orderId", id);
//		System.out.println(name+"----"+URLEncoder.encode(name,"utf-8"));
        req.setAttribute("userName", URLEncoder.encode(userName,"utf-8"));
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }
    @RequestMapping("/manage/touporder")
    public void OrderTou(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EASYBUY_ORDER order=easybuy_orderService.selectById(Integer.parseInt(id));
        ArrayList<EASYBUY_DD> dlist= easybuy_ddService.selectById(Integer.parseInt(id));
        req.setAttribute("dlist", dlist);
        req.setAttribute("order", order);
        req.getRequestDispatcher("order-modify.jsp").forward(req, resp);
    }

}
