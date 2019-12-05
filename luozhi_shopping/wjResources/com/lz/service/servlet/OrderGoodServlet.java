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
import com.lz.pojo.Admincount;
import com.lz.util.FinalType;
/*
 * el表达式得到后台数据的界面，最初的界面
 */

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
		Admincount admin=(Admincount) request.getSession().getAttribute("admin");
		if (admin!=null) {			
			registDao dao=new registDaoImpl();
			List<GoodsOrderDto> list=dao.selectAllOrderByOrSta(FinalType.NOSHIPPED);
			if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).getGoid());
					List<GoodsOrdergoodDto> list1 = dao.selectAllGoodsByOrSta(list.get(i).getGoname());
//				System.out.println(list1);
					list.get(i).setGogoods(list1);
				}
			}
			request.setAttribute("list",list);
//		System.out.println(list);
			request.getRequestDispatcher("backstage/backstageindex.jsp").forward(request, response);
		}else {
			response.sendRedirect("backstage/AdminLogin.do");
		}
		
	}

}
