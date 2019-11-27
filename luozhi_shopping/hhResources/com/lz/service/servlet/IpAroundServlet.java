package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.IpAroundDao;
import com.lz.dao.impl.IpAroundImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;
import com.lz.pojo.Type;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/IpAroundServlet")
public class IpAroundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IpAroundServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=DBConnection1.getConnection();
		IpAroundDao dao=new IpAroundImpl();
		//IP周边中的大分类
		List<Type> typelist = dao.selectTypeTitleByIpAroundId(conn);
		request.setAttribute("typelist", typelist);
		//IP周边中的小分类
		List<Goods> littltypelist=dao.selectLittleTitleByIpAroundId(conn);
		request.setAttribute("littltypelist", littltypelist);
		//根据页面大小求得最大页码
		int maxPageNo = dao.selectMaxPageNo(conn, 20);
		//存我们的当前页的最大页码
		request.setAttribute("maxPageNo", maxPageNo);
		//存当前页的页码
		request.setAttribute("pageNo", 1);
		//存页面显示条数
		request.setAttribute("pageSize", 20);
		List<Goods> goodlist=dao.selectAllGoodsByIpAroundId(conn, 1, 20);
		System.out.println(goodlist);
		//Ip周边的所有商品展示		
		request.setAttribute("goodlist", goodlist);			
		request.getRequestDispatcher("ip_around.jsp").forward(request, response);
		DBConnection1.close(conn);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
