package com.lz.service.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.HotDao;
import com.lz.dao.impl.HotDaoImpl;
import com.lz.pojo.Goods;

@WebServlet("/HotServlet")
public class HotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HotServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotDao dao=new HotDaoImpl();
		List<Goods> list=dao.selectHot();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("hot.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
