package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.LoginDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.User;

import net.sf.json.JSONObject;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String upwd = request.getParameter("password");
		LoginDaoImpl ldao = new LoginDaoImpl();
		Connection conn = DBConnection1.getConnection();
		User u = ldao.login(conn, uname, upwd);
		PrintWriter out = response.getWriter();
		if(u==null){
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("code", 1001);
			jsonobj.put("loginmsg", "账号或密码错误");
			out.write(jsonobj.toString());
			out.flush();
			out.close();
		}else{
			request.getSession().setAttribute("user", u);
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("code", 1000);
			jsonobj.put("loginmsg", "成功");
			out.write(jsonobj.toString());
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
