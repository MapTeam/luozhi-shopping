package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

@WebServlet("/RegistCode")
public class RegistCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证码是否正确
		String cilentCode = request.getParameter("code");
		String serverCode = request.getSession().getAttribute("code").toString();
		PrintWriter pw=response.getWriter();
		if (cilentCode=="") {
			pw.write("m");
			return;
		}
		if(serverCode.equalsIgnoreCase(cilentCode)){
			pw.write("msg");
		}else{
			pw.write("ms");
		}
	}

}
