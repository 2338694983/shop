package com.hr.manage;


import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.service.EASYBUY_COMMENTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DelManage extends HttpServlet {
	@Autowired
	private EASYBUY_COMMENTService easybuy_commentService;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int num= easybuy_commentService.del(id);
		if(num>0){
			response.sendRedirect("manage-result.jsp");
			//response.getWriter().print("<script>alert('??????!');history.back();<script>");
		}else{
			response.getWriter().print("<script>alert('??????!');location.href='SelManage'<script>");
		}
	}
}
