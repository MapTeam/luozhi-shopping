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

@WebServlet("/RegistUnameIsUse")
public class RegistUnameIsUse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询名字是否注册过
				String name=request.getParameter("name");
				User user=new User();
				registDao regist=new registDaoImpl();
				boolean flag=regist.registSelectByName(name);
				if (flag) {
					JSONObject jo = JSONObject.fromObject(flag);
					PrintWriter pw=response.getWriter();
					pw.write(jo.toString());
				}
				
	}

}
