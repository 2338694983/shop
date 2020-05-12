package com.hr.controller;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.entity.EASYBUY_USER;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-17 11:55
 **/
@Controller
@RequestMapping("/")
public class ToProductController {
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYService easybuy_product_categoryService;
    @Autowired
    private EASYBUY_PRODUCTService easybuy_productService;
    @RequestMapping("/manage/toProductClassUpdate")
    public void ToProductClassUpdate(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EASYBUY_PRODUCT_CATEGORY epc = easybuy_product_categoryService.selectById(Integer.parseInt(id));
        req.setAttribute("epc", epc);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = easybuy_product_categoryService.selectAll();
        req.setAttribute("epclist", epclist);
        req.getRequestDispatcher("productClass-modify.jsp").forward(req, resp);
    }
    @RequestMapping("/manage/toProductUpdate")
    public void ToProductUpdate(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        EASYBUY_PRODUCT p = easybuy_productService.selectById(Integer.parseInt(id));
        req.setAttribute("p", p);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = easybuy_product_categoryService.selectFather();
        req.setAttribute("flist", flist);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = easybuy_product_categoryService.selectChild();
        req.setAttribute("clist", clist);
        req.getRequestDispatcher("product-modify.jsp").forward(req, resp);
    }
    @RequestMapping("/release")
    public void Personal(HttpServletRequest req,HttpServletResponse resp,
                         @RequestParam("productName")String productName,
                         @RequestParam("parentId")String productId,
                         @RequestParam("photo")String photo,
                         @RequestParam("productPrice")String productPrice,
                         @RequestParam("productDesc") String productDesc,
                         @RequestParam("productStock")String productStock
    )throws Exception{
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        EASYBUY_USER user = (EASYBUY_USER)session.getAttribute("name");
        if (user!=null){
            EASYBUY_PRODUCT easybuy_product = new EASYBUY_PRODUCT();
            easybuy_product.setEP_ID(Integer.parseInt(productId));
            easybuy_product.setEP_NAME(productName);
            easybuy_product.setEP_DESCRIPTION(productDesc);
            easybuy_product.setEP_PRICE(Integer.parseInt(productPrice));
            easybuy_product.setEP_STOCK(Integer.parseInt(productStock));
            int epcId=60;
            if (Integer.parseInt(productId)<=63){
                 epcId=57;
            }else  if (Integer.parseInt(productId)<=66){
                 epcId=58;
            }else  if (Integer.parseInt(productId)<=69){
               epcId=59;
            }else {
                 epcId=60;
            }
            easybuy_product.setEPC_ID(epcId);
            easybuy_product.setEPC_CHILD_ID(Integer.parseInt(productId));
            easybuy_product.setEP_FILE_NAME(photo);
            easybuy_productService.insertEP(easybuy_product);
        }else {
            out.print("<script>");
            out.print("alert('请您先登录');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
            return;
        }
    }
}
