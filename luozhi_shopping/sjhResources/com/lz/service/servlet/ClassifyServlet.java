package com.lz.service.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.ClassifyDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;

/**
 * 从主页跳到ip周边或数码
 * @author sjh
 *
 */
@WebServlet("/ClassifyServlet")
public class ClassifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category1 = request.getParameter("category1");
		if(category1!=null&&!"".equals(category1)){
			int category = Integer.parseInt(category1);
			ClassifyDaoImpl dao = new ClassifyDaoImpl();
			Connection conn = DBConnection1.getConnection();
			List<String> brands = dao.selectGbrandByCategory1(conn, category);
			List<String> types = dao.selectTypeByCategory1(conn, category);
			List<Goods> goods = dao.selectGoodsByCategory1(conn, category, 0, 40);
			request.setAttribute("brands", brands);
			request.setAttribute("types", types);
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("shuma.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
