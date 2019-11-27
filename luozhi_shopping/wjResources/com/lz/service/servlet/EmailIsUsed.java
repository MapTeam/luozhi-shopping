package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.registDao;
import com.lz.dao.impl.registDaoImpl;
import com.lz.pojo.User;

import net.sf.json.JSONObject;

@WebServlet("/EmailIsUsed")
public class EmailIsUsed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询email是否注册过
		String mail=request.getParameter("mail");
		System.out.println(mail);
		User user=new User();
		registDao regist=new registDaoImpl();
		User u=regist.registSelectByEmail(mail);
		JSONObject jo=new JSONObject();
		PrintWriter pw=response.getWriter();
		
		if (u!=null) {
			
			jo.put("registed", true);
			pw.write(jo.toString());
			pw.flush();
			pw.close();
			return;
		}else {
			jo.put("registed", false);
			pw.write(jo.toString());
			pw.flush();
			pw.close();
		}
		
	}

}
