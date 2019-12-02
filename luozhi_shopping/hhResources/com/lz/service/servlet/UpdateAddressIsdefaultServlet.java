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

import com.lz.dao.ShopCurrentDao;
import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;

import net.sf.json.JSONObject;

/**
 * 更改默认地址
 */
@WebServlet("/UpdateAddressIsdefaultServlet")
public class UpdateAddressIsdefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateAddressIsdefaultServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得地址id
		String addrid=request.getParameter("addrid");
//		System.out.println(addrid);
		if (addrid!=null) {
			int addressid=Integer.parseInt(addrid);
			UserInfo userinfo=(UserInfo)request.getSession().getAttribute("userinfo");
			int uid=userinfo.getUser().getUid();
			Connection conn=DBConnection1.getConnection();
			try {
				conn.setAutoCommit(false);
				ShopCurrentDao dao=new ShopCurrentDaoImpl();
				//将所有默认值改为0
				boolean flag1= dao.updateAllisdefault(conn, uid);
				//将选中的那个默认值改为1
				boolean flag2=dao.updateDefaultByAddressId(conn, addressid);
				conn.commit();
				if (flag1&&flag2) {
					PrintWriter out=response.getWriter();
					JSONObject jo=new JSONObject();
					jo.put("ifUpdateDefaultAddrSuccess", true);
					out.write(jo.toString());
					out.flush();
					out.close();
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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
