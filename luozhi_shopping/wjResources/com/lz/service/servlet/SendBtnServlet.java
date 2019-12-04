package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.registDao;
import com.lz.dao.impl.registDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.util.CreateName;
import com.lz.util.FinalType;

import net.sf.json.JSONObject;

@WebServlet("/SendBtnServlet")
public class SendBtnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String sta=request.getParameter("status");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String ui=request.getParameter("uid");
		String msg=request.getParameter("msg");
		System.out.println(id);
		System.out.println(sta);
		System.out.println(address);
		System.out.println(tel);
		System.out.println(ui);
		System.out.println(msg);
		//插入出货号
		if (id!=null && address!=null && tel!=null  && sta!=null && ui!=null && msg==null) {
			int soid=Integer.parseInt(id);
			int status=Integer.parseInt(sta);
//			System.out.println(ui);
			int uid=Integer.parseInt(ui);
			Connection conn=DBConnection1.getConnection();
			try {
				conn.setAutoCommit(false);
				registDao dao=new registDaoImpl();
				String outgoodsname=CreateName.createOutGoodsId(uid);
				boolean flag1=dao.insertOutGoodsOrder(conn, outgoodsname, uid, address, tel);
				boolean flag2=dao.updateGoodOrder(conn, outgoodsname, status, soid);
//				System.out.println(flag2);
				conn.commit();
				if (flag2 && flag1) {
					JSONObject jo=new JSONObject().fromObject(flag1);
					PrintWriter pw=response.getWriter();
					pw.write(jo.toString());
					pw.flush();
					pw.close();
				}
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				DBConnection1.close(conn);
			}
			
		}
		//更改状态码
		if (id!=null && sta!=null && address==null && tel==null && ui==null && msg==null) {
			int soid=Integer.parseInt(id);
			int status=Integer.parseInt(sta);
			registDao dao=new registDaoImpl();
			boolean flag=dao.selectBySoid(soid, status);
			JSONObject jo=new JSONObject().fromObject(flag);
			PrintWriter pw=response.getWriter();
			pw.write(jo.toString());
			pw.flush();
			pw.close();
		}
		
		if (id!=null && msg!=null && sta!=null && address==null && tel==null  && ui==null) {
			int soid=Integer.parseInt(id);
			int status=Integer.parseInt(sta);
			registDao dao=new registDaoImpl();
			boolean flag=dao.updateUserReason(status, soid, msg);
//			System.out.println(flag);
			JSONObject jo=new JSONObject().fromObject(flag);
			PrintWriter pw=response.getWriter();
			pw.write(jo.toString());
			pw.flush();
			pw.close();
		}
		
	}

}
