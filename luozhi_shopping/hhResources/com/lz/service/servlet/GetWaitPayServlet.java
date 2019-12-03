package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.BaseDao;
import com.lz.dao.ShopCurrentDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;
import com.lz.pojo.GoodsOrder;
import com.lz.pojo.Goodsordergcolor;
import com.lz.util.FinalType;
import com.lz.util.SetGonameUtil;

import net.sf.json.JSONObject;

/**
 * 在订单中将其变成待付款状态
 */
@WebServlet("/GetWaitPayServlet")
public class GetWaitPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetWaitPayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addrid=request.getParameter("addrid");
		String gcolorid=request.getParameter("gcolorid");
		String goodscount=request.getParameter("goodscount");
//		System.out.println(addrid+"===="+gcolorid+"==="+goodscount);
		if (addrid!=null&&gcolorid!=null&&goodscount!=null) {
			String[] gcidarr=gcolorid.split(",");
			String[] gcountarr=goodscount.split(",");
			UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userinfo");
			int uid=userinfo.getUser().getUid();
			int addressid=Integer.parseInt(addrid);
			String goname=SetGonameUtil.GetNewgoname(uid);
			GoodsOrder go=new GoodsOrder();
			go.setOutgoodid(0);
			go.setReason(null);
			go.setRefusereason(null);
			go.setAddressid(addressid);
			go.setGodate(new Date());
			go.setGoname(goname);
			go.setUid(uid);
			go.setGostate(FinalType.NOPAY);
			//将相关信息插入订单表
			Connection conn1=DBConnection1.getConnection();
			BaseDao basedao=new BaseDaoImpl();
			boolean flag=basedao.insertObject(conn1, go);
			DBConnection1.close(conn1);
			//如果插入成功再查
			if (flag) {
				//得到该订单表的goid
				Connection conn2=DBConnection1.getConnection();
				ShopCurrentDao shopdao=new ShopCurrentDaoImpl();
				//将颜色id、数量、订单gid插到Goodsordergcolor这个表当中
				int goid=shopdao.selectGoidByGoname(conn2, goname);
				BaseDao basedao1=new BaseDaoImpl();
				//建立一个计数器，目的是判断是否全部都插入进去
				int count=0;
				for (int i = 0; i < gcountarr.length; i++) {
					int gcoloid=Integer.parseInt(gcidarr[i]);
					int gcount=Integer.parseInt(gcountarr[i]);
					Goodsordergcolor gcgc=new Goodsordergcolor();
					gcgc.setGcolorid(gcoloid);
					gcgc.setGoid(goid);
					gcgc.setGoodsnum(gcount);
					boolean flag2=basedao1.insertObject(conn2, gcgc);
					if (flag2) {
						count++;
					}
				}
				DBConnection1.close(conn2);
				if (count==gcountarr.length) {
					JSONObject jo=new JSONObject();
					jo.put("ifgetwaitpaysuccess",true);
					PrintWriter out=response.getWriter();
					out.write(jo.toString());
					out.flush();
					out.close();
				}
			}
			
			
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
