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
import com.lz.util.FinalType;

import net.sf.json.JSONArray;

@WebServlet("/OkOrderServlet")
public class OkOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registDao dao=new registDaoImpl();
		List<GoodsOrderDto> oklist=dao.selectAllOrderByOrSta(FinalType.SHIPPED);
//		System.out.println(oklist);
		JSONArray jar=new JSONArray().fromObject(oklist);
//		System.out.println(jar.toString());
		PrintWriter pw=response.getWriter();
		pw.write(jar.toString());
		pw.flush();
		pw.close();
		
	}

}
