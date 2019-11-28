package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.ClassifyDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.ClassifyDto;
import com.lz.pojo.Goods;

import net.sf.json.JSONObject;
/**
 * ajax获取商品与分页信息
 * @author sjh
 *
 */
@WebServlet("/ClassifyGetGoodsServlet")
public class ClassifyGetGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassifyGetGoodsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gbrand = request.getParameter("brand");
		String type = request.getParameter("type");
		String sort = request.getParameter("sort");
		String category1 = request.getParameter("category1");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		String pageNo = request.getParameter("pageNo");
		ClassifyDaoImpl cdao = new ClassifyDaoImpl();
		Connection conn = DBConnection1.getConnection();
		List<Goods> goods = cdao.selectGoods(conn, gbrand, type, sort, category1, min, max, pageNo);
		int pageCount = cdao.selectGoodsCount(conn, gbrand, type, category1, min, max);
		DBConnection1.close(conn);
//		for (Goods goods2 : goods) {
//			System.out.println(goods2);
//		}
//		System.out.println(pageCount);
		if(pageNo==null||"".equals(pageNo)||"0".equals(pageNo)){
			pageNo="1";
		}
//		System.out.println(pageCount);
		ClassifyDto cdto = new ClassifyDto();
		cdto.setGoods(goods);
		cdto.setPageCount(pageCount);
		cdto.setPageNo(Integer.parseInt(pageNo));
		JSONObject data = new JSONObject().fromObject(cdto);
		PrintWriter out = response.getWriter();
		out.write(data.toString());
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
