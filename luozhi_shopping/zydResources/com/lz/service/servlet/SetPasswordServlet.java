package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.SetPasswordDaoImpl;
import com.lz.dao.impl.registDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.User;
import com.lz.util.Md5;

import net.sf.json.JSONObject;

@WebServlet("/SetPasswordServlet")
public class SetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SetPasswordServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		if(pwd!=null&&!"".equals(pwd)){
			String email= (String) request.getSession().getAttribute("email");
			if(email!=null){
				 registDaoImpl res = new registDaoImpl();
				 User user = res.registSelectByEmail(email);
				 user.setUpwd(Md5.md5(pwd));
				 if(user!=null){
					 Connection conn = DBConnection1.getConnection();
					 BaseDao bdao = new BaseDaoImpl();
					 boolean flag = bdao.updateObjectById(conn, user);
					 obj.put("setpwdflag", flag);
				 }
			}else{
				System.out.println("email不知道怎么变空了！");
				obj.put("setpwdflag", false);
			}
			out.write(obj.toString());
			out.flush();
			out.close();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
