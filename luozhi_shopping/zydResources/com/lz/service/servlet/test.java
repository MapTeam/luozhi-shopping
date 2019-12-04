package com.lz.service.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.SetPasswordDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.User;

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn = DBConnection1.getConnection();
		 User user=new User();
		 user.setEmail("851649622@qq.com");
		 user.setUpwd("zhouyudong");
		 SetPasswordDaoImpl set=new SetPasswordDaoImpl();
		 boolean cpzhou=set.SetPassword(conn, user);
		 System.out.println(cpzhou);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
