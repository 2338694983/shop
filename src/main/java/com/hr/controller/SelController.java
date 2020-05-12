package com.hr.controller;

import com.hr.dao.*;
import com.hr.entity.*;
import com.hr.service.EASYBUY_COMMENTService;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import com.hr.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 10:00
 **/
@Controller
@RequestMapping("/")
public class SelController {
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYService easybuy_product_categoryService;
    @Autowired
    private EASYBUY_COMMENTService easybuy_commentService;
    @RequestMapping("/SelallServlet")
    public void Selall(HttpServletRequest req, HttpServletResponse resp,@RequestParam(value = "page",required = false) String spage)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int page=1;
        int pagesize=6;
        ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = easybuy_product_categoryService.selectFather();
        req.setAttribute("flist", flist);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = easybuy_product_categoryService.selectChild();
        req.setAttribute("clist", clist);
        if(spage!=null){
            page=Integer.parseInt(spage);
        }
        ArrayList<EASYBUY_COMMENT> list= easybuy_commentService.selPage(page, pagesize);
        int max_page=easybuy_commentService.getMax(pagesize);
        if(list.size()>0&&max_page>0){
            req.setAttribute("list", list);
            req.setAttribute("max_page", max_page);
            req.setAttribute("page", page);
            req.getRequestDispatcher("guestbook.jsp").forward(req,resp);
        }else{
            req.setAttribute("list", list);
            req.setAttribute("max_page", max_page);
            req.setAttribute("page", page);
            req.getRequestDispatcher("guestbook.jsp").forward(req,resp);
        }
    }
    @RequestMapping("/SelServlet")
    public void Sel(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<EASYBUY_COMMENT> list = easybuy_commentService.selectAll();
        ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = easybuy_product_categoryService.selectFather();
        req.setAttribute("flist", flist);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = easybuy_product_categoryService.selectChild();
        req.setAttribute("clist", clist);
        req.setAttribute("list", list);
        req.getRequestDispatcher("guestbook.jsp").forward(req,resp);
    }
}
