package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lz.dao.registDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.registDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.GoodsCar;
import com.lz.pojo.User;
import com.lz.util.Md5;

import net.sf.json.JSONObject;

@WebServlet("/registServlet")
public class registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDaoImpl bdao = new BaseDaoImpl();
		registDaoImpl rdao = new registDaoImpl();
		JSONObject jo=new JSONObject();
		PrintWriter out = response.getWriter();

		//注册
		String uname = request.getParameter("name");
		System.out.println(uname);
		String mail = request.getParameter("mail");
		System.out.println(mail);
		String pass = request.getParameter("pass");
		System.out.println(pass);
		String reg_user ="^[a-z0-9_]{3,20}$";
		String reg_email="^[a-zA-Z0-9_-]+(@qq.com|@163.com|@sina.com|@139.com|@126.com)$";
		String reg_pass= "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";

		if(uname!=null||pass!=null||mail!=null) {
			if (uname.matches(reg_user)&& mail.matches(reg_email)&&pass.matches(reg_pass)) {
				String password=Md5.md5(pass);
				User u = new User();
				u.setEmail(mail);
				u.setUname(uname);
				u.setCredits(0);
				u.setRegistdate(new Date());
				u.setUpicture("11");
				u.setUpwd(password);
				Connection conn = DBConnection1.getConnection();
				boolean flag2 = bdao.insertObject(conn, u);
				GoodsCar gcar = new GoodsCar(); 
				u = rdao.registSelectByEmail(mail);
				gcar.setUid(u.getUid());
				boolean flag1 = bdao.insertObject(conn, gcar);
				if(flag1&&flag2) {
					jo.put("code", 0);
					out.write(jo.toString());
					out.flush();
					out.close();
				}else {
					jo.put("code", 1);
					out.write(jo.toString());
					out.flush();
					out.close();
				}
				DBConnection1.close(conn);
			}
		}
		
		
		
		
	}

}
