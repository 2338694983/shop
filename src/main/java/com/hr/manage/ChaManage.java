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
public class ChaManage extends HttpServlet {
	@Autowired
	private EASYBUY_COMMENTService easybuy_commentService;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
 		ArrayList<EASYBUY_COMMENT> list = easybuy_commentService.selectAll();
 		//寄包裹
 	 	req.setAttribute("list", list);
 		//转发
 	 	req.getRequestDispatcher("guestbook.jsp").forward(req,resp);
 	}
}
