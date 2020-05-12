package com.hr.controller;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.eb_shop;
import com.hr.service.EASYBUY_PRODUCTService;
import com.hr.service.ESService;
import com.hr.util.EncodeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
 * @create: 2020-03-17 10:18
 **/
@Controller
@RequestMapping("/")
public class ShopController {
    @Autowired
    private EASYBUY_PRODUCTService easybuy_productService;
    @Autowired
    private ESService esService;
    @RequestMapping("/shopAdd2")
    public void ShopAdd2(HttpServletRequest req, HttpServletResponse resp,@RequestParam("id")String pid,@RequestParam("count") String count)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        EASYBUY_USER user = (EASYBUY_USER) session.getAttribute("name");
        if (user != null) {
            int stock = esService.findByStock(Integer.parseInt(pid));
            if (stock<=0){
                out.print("<script>");
                out.print("alert('购物失败，商品库存不足请重新选择商品');");
                out.print("location.href='indexSelect';");
                out.print("</script>");
                out.close();
            }else {
                EASYBUY_PRODUCT p = null;
                if (pid != null) {
                    p = easybuy_productService.selectById(Integer.parseInt(pid));
                }
                eb_shop eb = esService.selectShop(user.getEU_USER_ID(), Integer.parseInt(pid));
                if (eb == null){
                    String uid = user.getEU_USER_ID();
                    int valid = 1;
                    eb_shop sp = new eb_shop(0, p.getEP_FILE_NAME(), p.getEP_NAME(), p.getEP_PRICE(), Integer.parseInt(count), p.getEP_STOCK(), p.getEP_ID(), uid, valid);
                    int epid = p.getEP_ID();
                    esService.insert(sp);
                    resp.sendRedirect("selectProductView?id=" + epid);
                } else {
                    if(eb.es_eod_quantity>=p.getEP_STOCK()){
                        out.print("<script>");
                        out.print("alert('购物失败，商品库存不足请重新选择商品');");
                        out.print("location.href='indexSelect';");
                        out.print("</script>");
                        out.close();
                    }else {
                    esService.updateShop(eb.es_id, Integer.parseInt(count));
                    int epid = p.getEP_ID();
                    resp.sendRedirect("selectProductView?id=" + epid);
                }
                }
            }
        }
        else {
            out.print("<script>");
            out.print("alert('请您先登录');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
            return;
        }


        //req.getRequestDispatcher("selectProductView?id=").forward(req, resp);
    }
    @RequestMapping("/shopAdd")
    protected void shopAdd(HttpServletRequest req, HttpServletResponse resp,@RequestParam("id")String pid,@RequestParam("count") String count)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        EASYBUY_USER user = (EASYBUY_USER) session.getAttribute("name");
//        判断用户是否登录
        if (user != null) {
            int stock = esService.findByStock(Integer.parseInt(pid));
//            判断物品库存是否小于等于0
            if (stock<=0){
                out.print("<script>");
                out.print("alert('购物失败，商品库存不足请重新选择商品');");
                out.print("location.href='indexSelect';");
                out.print("</script>");
                out.close();
            }else {
                EASYBUY_PRODUCT p = null;
                if (pid != null) {
                    p = easybuy_productService.selectById(Integer.parseInt(pid));
                }
                eb_shop eb = esService.selectShop(user.getEU_USER_ID(), Integer.parseInt(pid));
                if (eb == null){
                    String uid = user.getEU_USER_ID();
                    int valid = 1;
                    eb_shop sp = new eb_shop(0, p.getEP_FILE_NAME(), p.getEP_NAME(), p.getEP_PRICE(), Integer.parseInt(count), p.getEP_STOCK(), p.getEP_ID(), uid, valid);
                    int epid = p.getEP_ID();
                    esService.insert(sp);
                    resp.sendRedirect("ShopSelect");
                } else {
                    if(eb.es_eod_quantity>p.getEP_STOCK()){
                        out.print("<script>");
                        out.print("alert('购物失败，商品库存不足请重新选择商品');");
                        out.print("location.href='indexSelect';");
                        out.print("</script>");
                        out.close();
                        return;
                    }else {
                        esService.updateShop(eb.es_id, Integer.parseInt(count));
                        resp.sendRedirect("ShopSelect");
                    }
                }
            }

        }
        else {
            out.print("<script>");
            out.print("alert('请您先登录');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
            return;
        }


        //req.getRequestDispatcher("ShopSelect").forward(req, resp);
    }
    @Transactional
    @RequestMapping("/gmServlet")
    public void gm(HttpServletRequest arg0, HttpServletResponse arg1,@RequestParam("spID") String[] EP_ID,@RequestParam("isHideInMenu") String[] isHideInMenu,@RequestParam("number") String[] quantity,@RequestParam("sPPrice")String [] sPPrice,@RequestParam("jstext")String price )
            throws ServletException, IOException {
        arg1.setContentType("text/html;charset=utf-8");
        PrintWriter out=arg1.getWriter();
        EncodeUtil.encode(arg0);
        HttpSession session=arg0.getSession();
        EASYBUY_USER list=(EASYBUY_USER)session.getAttribute("name");
        //用户id
        String id=list.getEU_USER_ID();
        //用户姓名
        String name=list.getEU_USER_NAME();
        //用户地址
        String address=list.getEU_ADDRESS();
        //总价钱
        ////////////////
        //商品id
        //购买数量
        //商品单价
        //购买后对商品表的库存进行修改

        for(int i=0;i<EP_ID.length;i++){
            if (isHideInMenu[i].equals("true")){
//            System.out.println(isHideInMenu[i]);
//            System.out.println(op[i]);
//            System.out.println(op.length);
            int count5=esService.updateStock(Integer.parseInt(quantity[i]),Integer.parseInt(EP_ID[i]));
            if (count5==0){
                esService.getDeleteDD(Integer.parseInt(EP_ID[i]));
                out.print("<script>");
                out.print("alert('购物失败，商品库存不足请重新选择商品');");
                out.print("location.href='ShopSelect';");
                out.print("</script>");
                out.close();
            }}
        }
        //商品单个总价
        int [] pprice=new int[EP_ID.length];
        for(int i=0;i<EP_ID.length;i++){
            if (isHideInMenu[i].equals("true")) {
                pprice[i] = Integer.parseInt(quantity[i]) * Integer.parseInt(sPPrice[i]);
            }
        }
        /////////////////得到序列
        //往订单表里添加数据
        int count=esService.insertDD(id, name, address,Integer.parseInt(price));
        int getSequenceId=esService.getSequenceId();
        //循环往订单详情添加
        for(int i=0;i<EP_ID.length;i++){
            if (isHideInMenu[i].equals("true")) {
                EASYBUY_ORDER_DETAIL eod = new EASYBUY_ORDER_DETAIL(1, getSequenceId, Integer.parseInt(EP_ID[i]), Integer.parseInt(quantity[i]), pprice[i]);
                int count2 = esService.eodInsert(eod);
            }
        }
        /////
        if(count>0){
            String [] esID=arg0.getParameterValues("esID");
            for(int i=0;i<esID.length;i++){
                if (isHideInMenu[i].equals("true")){
                int count3 =esService.esdelete(Integer.parseInt(esID[i]));
            }}
            out.print("<script>");
            out.print("alert('购物成功');");
            out.print("location.href='shopping-result.jsp';");
            out.print("</script>");
            out.close();
            // 开单后，修改购物车
        }else{
            out.print("<script>");
            out.print("alert('购物失败，请重新选择商品');");
            out.print("location.href='ShopSelect';");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/ShopSelect")
    public void shopSelect(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {
        EncodeUtil.encode(arg0);
        arg1.setContentType("text/html;charset=utf-8");
        PrintWriter out = arg1.getWriter();
        HttpSession session=arg0.getSession();
        EASYBUY_USER userCZ=(EASYBUY_USER)session.getAttribute("name");
        if(userCZ!=null){
            EASYBUY_USER eu=(EASYBUY_USER)session.getAttribute("name");
            String id=(String)eu.getEU_USER_ID();
            ArrayList<eb_shop> list=esService.getShop(id);
            arg0.setAttribute("shoplist",list);
            arg0.getRequestDispatcher("shopping.jsp").forward(arg0, arg1);
        }else{
            out.print("<script>");
            out.print("alert('请您先登录');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
        }
    }
    @RequestMapping("/UpdateServlet")
    public void Update(HttpServletRequest arg0, HttpServletResponse arg1,@RequestParam("pid") String str1,@RequestParam("action")String str2,@RequestParam(value = "getvalue",required = false)String str3)
            throws ServletException, IOException {
        arg1.setContentType("text/html;charset=utf-8");
        PrintWriter out = arg1.getWriter();
        if(str2.equals("jia")){
            int count=esService.updateJia(Integer.parseInt(str1));
        }
        if(str2.equals("jian")){
            int count=esService.updateJian(Integer.parseInt(str1));

        }
        if(str2.equals("closeText")){
            eb_shop es=new eb_shop(Integer.parseInt(str1), "1", "1", 1, Integer.parseInt(str3), 1, 1, "1", 1);
            int count=esService.updateClose(es);
        }
        if(str2.equals("delText")){
            int count=esService.getDeleteDD(Integer.parseInt(str1));
        }
        arg1.sendRedirect("ShopSelect");
    }


}
