package com.lz.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 从session移除ajax传过来的值的键
 * @author sjh
 *
 */
@WebServlet("/RemoveSingletStateLoginListenerMsgServlet")
public class RemoveSingletStateLoginListenerMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveSingletStateLoginListenerMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("value");
		if(str!=null&&!"".equals(str)){
			request.getSession().removeAttribute(str);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
