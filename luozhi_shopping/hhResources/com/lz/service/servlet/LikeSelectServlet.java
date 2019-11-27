package com.lz.service.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.LikeSelectDao;
import com.lz.dao.impl.LikeSelectDaoImpl;
import com.lz.pojo.Goods;

/**
 * Servlet implementation class LikeSelectServlet
 */
@WebServlet("/LikeSelectServlet")
public class LikeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LikeSelectServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LikeSelectDao dao=new LikeSelectDaoImpl();
		String key=request.getParameter("val");
		//定义pageNo为变量，pageSize为变量
		int pageSize = 20;
		String size = request.getParameter("pageSize");
		//第一次进来
		if(size==null){
			size = "20";
		}
		pageSize = Integer.parseInt(size);
		if(pageSize<1){
			pageSize = 20;
		}
		//根据页面大小求得最大页码
		int maxPageNo = dao.selectMaxPageNo(key, pageSize);
		//存我们的当前页的最大页码
		request.setAttribute("maxPageNo", maxPageNo);
		int pageNo = 1;
		String no = request.getParameter("pageNo");
		if(no==null || "0".equals(no)){
			no = "1";//表示从首页跳转过来
		}
		pageNo = Integer.parseInt(no);
		if(pageNo > maxPageNo&&maxPageNo!=0){
			pageNo = maxPageNo;
		}
		//存我们的当前页的页码
		request.setAttribute("pageNo", pageNo);
		//存我们的页面显示条数
		request.setAttribute("pageSize", pageSize);	
		
		List<Goods> list=dao.selectGoodsByKey(key, pageNo, pageSize);
		if(list.size()==0) {
			request.setAttribute("likemsg", 0);
		}
		request.setAttribute("title", key);
		request.setAttribute("list", list);
		request.getRequestDispatcher("like_select.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
