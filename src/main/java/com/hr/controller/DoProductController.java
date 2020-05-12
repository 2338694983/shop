package com.hr.controller;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import com.hr.util.EncodeUtil;
import com.jspsmart.upload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: shop2
 * @description:
 * @author: Mr.L
 * @create: 2020-03-16 17:22
 **/
@Controller
@RequestMapping("/")
public class DoProductController implements ServletConfigAware, ServletContextAware {
    @Autowired
    private EASYBUY_PRODUCTService easybuy_productService;
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYService easybuy_product_categoryService;
    private ServletContext servletContext;
    public void setServletContext(ServletContext arg0) {
        this.servletContext = arg0;
    }
    private ServletConfig servletConfig;
    public void setServletConfig(ServletConfig arg0) {
        this.servletConfig = arg0;
    }

    @RequestMapping("/manage/doProductAdd")
    public void DoProductAdd(HttpServletRequest req, HttpServletResponse resp,String productName,String parentId,String productPrice,String productDesc,String productStock)
            throws ServletException, IOException {
        SmartUpload su = new SmartUpload();
        su.initialize(servletConfig, req, resp);

        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        Files fs = su.getFiles();
        File f = fs.getFile(0);
        String fname = f.getFileName();
        try {
            su.save("images/product");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request req1 = su.getRequest();
        EASYBUY_PRODUCT p = null;
        if(productPrice!=null && productStock!=null && parentId!=null){
            p = new EASYBUY_PRODUCT(0, productName, productDesc,
                    Integer.parseInt(productPrice),
                    Integer.parseInt(productStock),
                    Integer.parseInt(parentId.split("-")[0]),
                    Integer.parseInt(parentId.split("-")[1]),
                    fname);
        }
        int count = 0;
        if(p!=null){
            count = easybuy_productService.insert(p);
        }
        req.getRequestDispatcher("productSelect").forward(req, resp);
    }
    @RequestMapping("/manage/doProductClassAdd")
    public void DoProductClassAdd(HttpServletRequest req, HttpServletResponse resp,String parentId,String className)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        req.setCharacterEncoding("utf-8");
        if(Integer.parseInt(parentId)==0){
            EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, className, 0);
            easybuy_product_categoryService.insertOnFather(pc);
        }else{
            EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, className,Integer.parseInt(parentId));
            easybuy_product_categoryService.insert(pc);
        }
        resp.sendRedirect("productClass");
    }
    @RequestMapping("/manage/doProductClassUpdate")
    public void DoProductClassUpdate(HttpServletRequest req, HttpServletResponse resp,String id,String parentId,String className)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        EASYBUY_PRODUCT_CATEGORY pc;
        if(Integer.parseInt(parentId)==0){
            pc = new EASYBUY_PRODUCT_CATEGORY(Integer.parseInt(id),className,0);
        }else{
            pc = new EASYBUY_PRODUCT_CATEGORY(Integer.parseInt(id),className, Integer.parseInt(parentId));
        }
        easybuy_product_categoryService.update(pc);
        resp.sendRedirect("productClass");
    }
    @RequestMapping("/manage/doProductUpdate")
    public void DoProductUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SmartUpload su = new SmartUpload();
        su.initialize(servletConfig, req, resp);
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request req1 = su.getRequest();
        String id=req1.getParameter("id");
        String productName=req1.getParameter("productName");
        String parentId=req1.getParameter("parentId");
        String productPrice=req1.getParameter("productPrice");
        String productDesc=req1.getParameter("productDesc");
        String productStock=req1.getParameter("productStock");

        Files fs = su.getFiles();//获得所有文件
        File f = fs.getFile(0);//获得上传的文件
        String fname = f.getFileName();//获得文件名
        try {
            su.save("images/product");//保存图片到指定位置
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(Integer.parseInt(id),
                productName,
                productDesc,
                Integer.parseInt(productPrice),
                Integer.parseInt(productStock),
                Integer.parseInt(parentId.split("-")[0]),
                Integer.parseInt(parentId.split("-")[1]),
                fname);
        int count = 0;
        if(p!=null){
            count = easybuy_productService.update(p);
        }
        req.getRequestDispatcher("productSelect").forward(req, resp);

    }

}
