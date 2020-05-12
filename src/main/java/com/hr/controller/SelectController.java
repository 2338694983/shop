package com.hr.controller;

import com.hr.dao.EASYBUY_DdanDao;
import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_Ddan;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.service.EASYBUY_DdanService;
import com.hr.service.EASYBUY_NEWSService;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.EASYBUY_PRODUCT_CATEGORYService;
import com.hr.util.EncodeUtil;
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
 * @create: 2020-03-17 10:10
 **/
@Controller
@RequestMapping("/")
public class SelectController {
    @Autowired
    private EASYBUY_PRODUCT_CATEGORYService easybuy_product_categoryService;
    @Autowired
    private EASYBUY_PRODUCTService easybuy_productService;
    @Autowired
    private EASYBUY_NEWSService easybuy_newsService;
    @Autowired
    private EASYBUY_DdanService easybuy_ddanService;
    @RequestMapping("/selectdd")
    public void SelectDD(HttpServletRequest req, HttpServletResponse resp,String dd)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
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
        EncodeUtil.encode(req);
        ArrayList<EASYBUY_Ddan> dan= easybuy_ddanService.selectById(dd);
        req.setAttribute("dan", dan);
        req.getRequestDispatcher("Dan.jsp").forward(req, resp);
    }
    @RequestMapping("/selectProductList")
    public void SelectProductList(HttpServletRequest req, HttpServletResponse resp,String fid,String cid,String name)
            throws ServletException, IOException {
        EncodeUtil.encode(req);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = easybuy_product_categoryService.selectFather();
        req.setAttribute("flist", flist);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = easybuy_product_categoryService.selectChild();
        req.setAttribute("clist", clist);
        HttpSession session = req.getSession();
        //查询最近浏览的商品
        ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
        if(ids!=null){
            ArrayList<EASYBUY_PRODUCT> lastlylist = easybuy_productService.selectById(ids);
            req.setAttribute("lastlylist", lastlylist);
        }

        int cpage = 1;//当前页数
        int count = 8;//每页行数
        String cp = req.getParameter("cp");
        if(cp!=null){//如果页面上传递了页数,将当前页数改变掉
            cpage = Integer.parseInt(cp);
        }
        //查出总页数
        int tpage = 0;
        ArrayList<EASYBUY_PRODUCT> list = null;
        if(fid==null&&cid==null){
            list = easybuy_productService.selectAll(cpage, count);
            req.setAttribute("title", "全部商品");
            tpage = easybuy_productService.totalPage(count);
        }
        if(fid!=null){
            int id = Integer.parseInt(fid);
            list = easybuy_productService.selectAllByFid(cpage, count, id);
            tpage = easybuy_productService.totalPageByFid(count, id);
            req.setAttribute("title", easybuy_product_categoryService.selectById(id).getEPC_NAME());
        }
        if(cid!=null){
            int id = Integer.parseInt(cid);
            list = easybuy_productService.selectAllByCid(cpage, count, id);
            tpage = easybuy_productService.totalPageByCid(count, id);
            req.setAttribute("title", easybuy_product_categoryService.selectById(id).getEPC_NAME());
        }
        if(name!=null){
            list = easybuy_productService.selectAllByName(name);
            tpage = easybuy_productService.totalPageByName(count, name);
            req.setAttribute("title", "搜索商品："+name);
        }
        req.setAttribute("list", list);
        //当前页数
        req.setAttribute("cpage", cpage);
        //总页数
        req.setAttribute("tpage", tpage);
        //搜索关键字
        req.setAttribute("search_words", name);
        //父分类
        req.setAttribute("selected_fid", fid);
        req.getRequestDispatcher("product-list.jsp").forward(req, resp);
    }
    @RequestMapping("/selectProductView")
    public void SelectProductViewServlet(HttpServletRequest req, HttpServletResponse resp,String id)
            throws ServletException, IOException {
        ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = easybuy_product_categoryService.selectFather();
        req.setAttribute("flist", flist);
        ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = easybuy_product_categoryService.selectChild();
        req.setAttribute("clist", clist);
        HttpSession session = req.getSession();
        ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
        if(ids==null){
            ids = new ArrayList<Integer>();
        }
        if(ids.size()>=5){
            ids.remove(0);
        }
        if(id!=null&&(!ids.contains(Integer.parseInt(id)))){
            ids.add(Integer.parseInt(id));
        }
        session.setAttribute("ids", ids);
        ids = (ArrayList<Integer>) session.getAttribute("ids");
        if(ids!=null){
            ArrayList<EASYBUY_PRODUCT> lastlylist = easybuy_productService.selectById(ids);
            req.setAttribute("lastlylist", lastlylist);
        }
        EASYBUY_PRODUCT p = null;
        if(id!=null){
            p = easybuy_productService.selectById(Integer.parseInt(id));
        }
        req.setAttribute("p", p);
        req.getRequestDispatcher("product-view.jsp").forward(req, resp);
    }

}
