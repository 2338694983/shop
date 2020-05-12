package com.hr.controller;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 09:46
 **/
@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYService easybuy_product_categoryService;
    @Autowired
    private EASYBUY_PRODUCTService easybuy_productService;
    @RequestMapping("/manage/productAdd")
    public void ProductAdd(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = easybuy_product_categoryService.selectFather();
        req.setAttribute("flist", flist);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = easybuy_product_categoryService.selectChild();
        req.setAttribute("clist", clist);
        req.getRequestDispatcher("product-add.jsp").forward(req, resp);
    }

    @RequestMapping("/manage/productClassAdd")
    public void ProductClassAdd(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = easybuy_product_categoryService.selectAll();
        req.setAttribute("epclist", epclist);
        req.getRequestDispatcher("productClass-add.jsp").forward(req, resp);
    }
    @RequestMapping("/manage/productClassDel")
    public void ProductClassDel(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        easybuy_product_categoryService.del(Integer.parseInt(id));
        resp.sendRedirect("productClass");
    }
    @RequestMapping("/manage/productClass")
    public void ProductClass(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = easybuy_product_categoryService.selectAll();
        req.setAttribute("epclist", epclist);
        req.getRequestDispatcher("productClass.jsp").forward(req, resp);
    }
    @RequestMapping("/manage/productDel")
    public void ProductDel(HttpServletRequest req, HttpServletResponse resp,@RequestParam(required = false) String id)
            throws ServletException, IOException {
        int count = easybuy_productService.del(Integer.parseInt(id));
        if(count>0){
            req.getRequestDispatcher("productSelect").forward(req, resp);
        }
    }
    @RequestMapping("/manage/productSelect")
    public void ProductSelect(HttpServletRequest req, HttpServletResponse resp,String cp)
            throws ServletException, IOException {
        int cpage = 1;
        int count = 5;
        if(cp!=null){
            cpage = Integer.parseInt(cp);
        }
        int tpage = 0;
        ArrayList<EASYBUY_PRODUCT> eplist = easybuy_productService.selectAll(cpage, count);
        tpage = easybuy_productService.totalPage(count);
        req.setAttribute("eplist", eplist);
        req.setAttribute("cpage", cpage);
        req.setAttribute("tpage", tpage);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }
}