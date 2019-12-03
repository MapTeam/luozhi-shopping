package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.lz.pojo.GoodsOrder;
import com.lz.util.FinalType;

import net.sf.json.JSONArray;

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
		String sta=request.getParameter("status");
		registDao dao=new registDaoImpl();
		int status=Integer.parseInt(sta);
		List<GoodsOrderDto> list=null;
		if (status==1) {
			list=dao.selectOrderByOrSta(status);
		}else {
			list=dao.selectAllOrderByOrSta(status);
		}
		for (int i = 0; i < list.size(); i++) {
			List<GoodsOrdergoodDto> list1 = dao.selectAllGoodsByOrSta(list.get(i).getGoid());
//			System.out.println(list1);
			list.get(i).setGogoods(list1);
		}
//		System.out.println(list);
//		request.setAttribute("list",list);
		JSONArray jar = new JSONArray().fromObject(list);
		PrintWriter pw = response.getWriter();
		pw.write(jar.toString());
		pw.flush();
		pw.close();
//		request.getRequestDispatcher("backstage/backstageindex.jsp").forward(request, response);
	}

}
