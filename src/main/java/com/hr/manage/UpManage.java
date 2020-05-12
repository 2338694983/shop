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
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UpManage extends HttpServlet {
	@Autowired
	private EASYBUY_COMMENTService easybuy_commentService;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("orderId"));
		String name=request.getParameter("name");
		String replyContent=request.getParameter("replyContent");
		String Content=request.getParameter("Content");
		Date date=new Date();
		System.out.println(Content);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replyTime=sdf.format(date);
		EASYBUY_COMMENT comment=new EASYBUY_COMMENT(id,Content,replyTime,replyContent,replyTime,name);
	 
		//System.out.println(id+"--"+content+"--"+replyTime+"--"+replyContent+"--"+name);
		comment.setEC_ID(id);
		int num= easybuy_commentService.update(comment);
		if(num>0){
			response.sendRedirect("manage-result.jsp");
		}else{
			response.getWriter().print("<script>alert('更新失败！');history.back();</script>");
		}
	}
}
