package com.lz.service.servlet;
/**
 * 添加地址
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.BaseDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Address;

import net.sf.json.JSONObject;

@WebServlet("/InsertAddressServlet")
public class InsertAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertAddressServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到添加地址所需要的内容
		String userid=request.getParameter("uid");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String addr1=request.getParameter("addr1");
		String detail=request.getParameter("addr2");
		if (userid!=null&&name!=null&&tel!=null&&addr1!=null&&detail!=null) {
			String[] addr=addr1.split("-");
			String province=addr[0];
			String city=addr[1];
			String village=addr[2];
			int uid=Integer.parseInt(userid);
			Address address=new Address();
			address.setCity(city);
			address.setDetail(detail);
			address.setIsdefault(1);
			address.setName(name);
			address.setProvince(province);
			address.setTel(tel);
			address.setVillage(village);
			address.setUid(uid);
			BaseDao dao=new BaseDaoImpl();
			Connection conn=DBConnection1.getConnection();
			boolean flag=dao.insertObject(conn, address);
			DBConnection1.close(conn);
			PrintWriter out=response.getWriter();
			JSONObject jo=new JSONObject();
			jo.put("ifInsertAddrSuccess", flag);
			out.write(jo.toString());
			out.flush();
			out.close();
		}
//		System.out.println(uid+name+tel+province+city+village+detail);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
