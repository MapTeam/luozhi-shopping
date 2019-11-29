package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.BaseDao;
import com.lz.dao.GoodsParticularDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.GoodsParticularDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;
import com.lz.pojo.GoodsCar;
import com.lz.pojo.GoodscarGoods;

import net.sf.json.JSONObject;
/**
 * 在商品详情块加入购物车
 * @author Administrator
 *
 */
@WebServlet("/AddGoodcardByGoodsParticularServlet")
public class AddGoodcardByGoodsParticularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddGoodcardByGoodsParticularServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gcolorid=request.getParameter("gcolorid");
		String userid=request.getParameter("userid");
		String goodnum=request.getParameter("goodnum");
//		System.out.println(gcolorid+"   "+userid+"   "+goodnum);
		if (gcolorid!=null&&userid!=null&&goodnum!=null) {
			Connection conn=DBConnection1.getConnection();
			GoodscarGoods gcg=new GoodscarGoods();
			GoodsParticularDao getgciddao=new GoodsParticularDaoImpl();
			int gcid=getgciddao.selectGcigByUid(conn, Integer.parseInt(userid));
			gcg.setGcid(gcid);
			gcg.setGcolorid(Integer.parseInt(gcolorid));
			gcg.setGoodsnum(Integer.parseInt(goodnum));
			gcg.setUid(Integer.parseInt(userid));
			BaseDao dao =new BaseDaoImpl();
			boolean flag=dao.insertObject(conn, gcg);
			if(flag){
				//修改session里的购物车数量
				UserInfo userinfo = (UserInfo) request.getSession().getAttribute("userinfo");
				userinfo.setShopcargoodsnum(userinfo.getShopcargoodsnum()+1);
			}
			DBConnection1.close(conn);
			JSONObject jo=new JSONObject();
			jo.put("addgoodscatflag",flag);
			PrintWriter out=response.getWriter();
			out.write(jo.toString());
			out.flush();
			out.close();
			
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
