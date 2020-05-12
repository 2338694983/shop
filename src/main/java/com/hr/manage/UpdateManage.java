package com.hr.manage;


import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;
import com.hr.service.EASYBUY_COMMENTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Repository
public class UpdateManage extends HttpServlet {
	@Autowired
	private EASYBUY_COMMENTService easybuy_commentService;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		EASYBUY_COMMENT comment= easybuy_commentService.selOne(id);
		if(comment!=null){
			request.setAttribute("list",comment);
			request.getRequestDispatcher("guestbook-modify.jsp").forward(request, response);
		}else{
			response.getWriter().print("<script>alert('查询失败！');history.back();</script>");
		}
	}
}
