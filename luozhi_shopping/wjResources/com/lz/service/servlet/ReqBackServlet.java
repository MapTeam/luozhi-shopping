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
import com.lz.dto.GoodsBackDto;
import com.lz.dto.GoodsOrderDto;
import com.lz.util.FinalType;

import net.sf.json.JSONArray;

@WebServlet("/ReqBackServlet")
public class ReqBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registDao dao=new registDaoImpl();
		String sta=request.getParameter("status");
		int status=Integer.parseInt(sta);
		List<GoodsBackDto> backlist=dao.selectOrderByOrsta(status);
		System.out.println(backlist);
		JSONArray jarr=new JSONArray().fromObject(backlist);
		PrintWriter pw=response.getWriter();
		pw.write(jarr.toString());
		pw.flush();
		pw.close();
	}

}
