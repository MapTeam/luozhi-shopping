package com.lz.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出登录
 * @author sjh
 *
 */
@WebServlet("/ExitLoginServlet")
public class ExitLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExitLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(111);
		request.getSession().removeAttribute("userinfo");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
