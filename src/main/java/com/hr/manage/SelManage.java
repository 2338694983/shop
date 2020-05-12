package com.hr.manage;


import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;
import com.hr.service.EASYBUY_COMMENTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@Controller
public class SelManage extends HttpServlet {
	@Autowired
	private EASYBUY_COMMENTService easybuy_commentService;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int page=1; //当前页数
		int pagesize=6;//每页行数
		String spage=req.getParameter("page");
		if(spage!=null){ //如果页面上传递了页数,将当前页数改变掉
			page=Integer.parseInt(spage);
		
		}
		//查出总页数
		ArrayList<EASYBUY_COMMENT> list= easybuy_commentService.selPage(page, pagesize);
		int max_page= easybuy_commentService.getMax(pagesize);
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
 
}
