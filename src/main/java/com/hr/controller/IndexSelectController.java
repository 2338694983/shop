package com.hr.controller;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.service.EASYBUY_NEWSService;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
 * @create: 2020-03-17 10:54
 **/
@Controller
@RequestMapping("/")
public class IndexSelectController {
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYService easybuy_product_categoryService;
    @Autowired
    private EASYBUY_PRODUCTService easybuy_productService;
    @Autowired
    private EASYBUY_NEWSService easybuy_newsService;
    @RequestMapping("/indexSelect")
    public void IndexSelect(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = easybuy_product_categoryService.selectFather();
        req.setAttribute("flist", flist);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = easybuy_product_categoryService.selectChild();
        req.setAttribute("clist", clist);
        ArrayList<EASYBUY_PRODUCT> tlist = easybuy_productService.selectAllByT();
        req.setAttribute("tlist", tlist);
        ArrayList<EASYBUY_PRODUCT> hlist = easybuy_productService.selectAllByHot();
        req.setAttribute("hlist", hlist);
        ArrayList<EASYBUY_NEWS> nlist = easybuy_newsService.selectAll1();
        req.setAttribute("nlist", nlist);
        HttpSession session = req.getSession();
        ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
        if(ids!=null){
            ArrayList<EASYBUY_PRODUCT> lastlylist = easybuy_productService.selectById(ids);
            req.setAttribute("lastlylist", lastlylist);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
