package com.lz.service.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.dao.BackstageLoginDao;
import com.lz.dao.impl.BackstageLoginDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Admincount;
import com.lz.util.Md5;

/**
 * 后台登录
 */
@WebServlet("/BackstageLoginServlet")
public class BackstageLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackstageLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String upass=request.getParameter("password");
		if (uname!=null&&!"".equals(uname)&&upass!=null&&!"".equals(upass)) {
			Connection conn=DBConnection1.getConnection();
			BackstageLoginDao dao=new BackstageLoginDaoImpl();
			Admincount admin=dao.selectPasswordByuserame(conn, uname);
			DBConnection1.close(conn);
			String password=Md5.md5(upass);
			
			if (admin!=null&&password.equals(admin.getApwd())) {
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect("OrderGoodServlet");
			}else {
				response.sendRedirect("AdminLogin");
			}
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
