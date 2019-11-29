package com.lz.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShopCurrentServlet")
public class ShopCurrentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShopCurrentServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String gcolorid=request.getParameter("gcolorid");
			String userid=request.getParameter("userid");
			String goodscount=request.getParameter("goodscount");
			
//			System.out.println("颜色id"+gcolorid+"用户id"+userid+"选择的数量"+goodscount);
//			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
