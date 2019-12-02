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
		if (id!=null && address!=null && tel!=null  && sta!=null) {
			int soid=Integer.parseInt(id);
			int status=Integer.parseInt(sta);
			int uid=Integer.parseInt(ui);
			Connection conn=DBConnection1.getConnection();
			try {
				conn.setAutoCommit(false);
				registDao dao=new registDaoImpl();
//				boolean flag1=dao.insertOutGoodsOrder(conn, outgoodsname, uid, address, tel);
//				JSONObject jo=new JSONObject().fromObject(flag1);
//				PrintWriter pw=response.getWriter();
//				pw.write(jo.toString());
//				pw.flush();
//				pw.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//			boolean flag=dao.selectBySoid(soid,status);
//			JSONObject jo=new JSONObject().fromObject(flag);
//			PrintWriter pw=response.getWriter();
//			pw.write(jo.toString());
//			pw.flush();
//			pw.close();
		}
		
		
		
	}

}
