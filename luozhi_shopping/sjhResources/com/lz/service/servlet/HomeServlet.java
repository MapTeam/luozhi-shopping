package com.lz.service.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.HomeDaoImpl;
import com.lz.pojo.Goods;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    public HomeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeDaoImpl hdao = new HomeDaoImpl();
		List<Goods> gs = hdao.getHomeGoods();
		List<Goods> res=hdao.getRecommandGoods();
		List<Goods> hs=hdao.getHotGoods();	
		System.out.println(gs.size());
		request.setAttribute("HomeGoods", gs);
		request.setAttribute("HotGoodsList", hs);
		request.setAttribute("RecommandGoodsList", res);
	       
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
