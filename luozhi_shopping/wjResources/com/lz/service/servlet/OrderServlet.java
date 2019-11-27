package com.lz.service.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.registDao;
import com.lz.dao.impl.registDaoImpl;
import com.lz.dto.GoodsOrderDto;
import com.lz.pojo.GoodsOrder;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registDao dao=new registDaoImpl();
		List<GoodsOrderDto> list=dao.selectAllOrderByOrSta();
		
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("backstage/backstageindex.jsp").forward(request, response);
	}

}
