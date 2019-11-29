package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.AddOrReduceCarDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.GoodscarGoods;

import net.sf.json.JSONObject;
/**
 * 购物车商品增加或减少
 * @author sjh
 *
 */
@WebServlet("/AddOrReduceCarGoodsServlet")
public class AddOrReduceCarGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddOrReduceCarGoodsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gcgid = request.getParameter("gcgid");
		String type = request.getParameter("type");
		boolean flag = false;
		BaseDaoImpl bdao = new BaseDaoImpl();
		PrintWriter out = response.getWriter();
		if(gcgid!=null&&!"".equals(gcgid)&&type!=null&&!"".equals(type)){
			Connection conn = DBConnection1.getConnection();
			GoodscarGoods gcg = new GoodscarGoods();
			gcg.setGcgid(Integer.parseInt(gcgid));
			gcg = (GoodscarGoods) bdao.selectObjectById(conn, gcg);
			if(Integer.parseInt(type)==AddOrReduceCarDao.ADD&&gcg!=null){
				gcg.setGoodsnum(gcg.getGoodsnum()+1);
			}
			if(Integer.parseInt(type)==AddOrReduceCarDao.REDUCE&&gcg!=null){
				gcg.setGoodsnum(gcg.getGoodsnum()-1);
			}
			if(gcg!=null){
				flag = bdao.updateObjectById(conn, gcg);
			}
			DBConnection1.close(conn);
			JSONObject obj = new JSONObject();
			obj.put("AddOrReduceMsg", flag);
			out.write(obj.toString());
			out.flush();
			out.close();
		}else{
			JSONObject obj = new JSONObject();
			obj.put("AddOrReduceMsg", flag);
			out.write(obj.toString());
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
