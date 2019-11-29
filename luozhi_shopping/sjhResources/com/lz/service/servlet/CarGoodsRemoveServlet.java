package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;
import com.lz.pojo.GoodscarGoods;

import net.sf.json.JSONObject;
/**
 * 购物车商品移除
 * @author sjh
 *
 */
@WebServlet("/CarGoodsRemoveServlet")
public class CarGoodsRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarGoodsRemoveServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gcgid = request.getParameter("gcgid");
//		System.out.println(gc_gid);
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		if(gcgid!=null&&!"".equals(gcgid)){
			BaseDaoImpl bdao = new BaseDaoImpl();
			GoodscarGoods gcg = new GoodscarGoods();
			gcg.setGcgid(Integer.parseInt(gcgid));
			Connection conn = DBConnection1.getConnection();
			//删除这条记录
			boolean flag = bdao.deleteObjectById(conn, gcg);
			if(flag){
				//修改session里的购物车数量
				UserInfo userinfo = (UserInfo) request.getSession().getAttribute("userinfo");
				userinfo.setShopcargoodsnum(userinfo.getShopcargoodsnum()-1);
			}
			obj.put("CarGoodsRemove", flag);
			out.write(obj.toString());
			out.flush();
			out.close();
		}else{
			obj.put("CarGoodsRemove", false);
			out.write(obj.toString());
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
