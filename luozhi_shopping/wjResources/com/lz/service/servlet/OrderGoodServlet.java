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
import com.lz.dto.GoodsOrdergoodDto;
import com.lz.util.FinalType;


@WebServlet("/OrderGoodServlet")
public class OrderGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderGoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registDao dao=new registDaoImpl();
		List<GoodsOrderDto> list=dao.selectAllOrderByOrSta(FinalType.NOSHIPPED);
		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getGoid());
			List<GoodsOrdergoodDto> list1 = dao.selectAllGoodsByOrSta(list.get(i).getGoname());
//			System.out.println(list1);
			list.get(i).setGogoods(list1);
		}
			
//		System.out.println(list);
		request.setAttribute("list",list);
		request.getRequestDispatcher("backstage/backstageindex.jsp").forward(request, response);
	}

}
