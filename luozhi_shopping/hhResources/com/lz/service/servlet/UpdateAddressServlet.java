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
import javax.servlet.http.HttpSession;

import com.lz.dao.BaseDao;
import com.lz.dao.ShopCurrentDao;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;
import com.lz.pojo.Address;

import net.sf.json.JSONObject;
/**
 * 修改地址的Servlet
 * @author Administrator
 *
 */
@WebServlet("/UpdateAddressServlet")
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addressid=request.getParameter("addressid");
		String isdefault=request.getParameter("isdefault");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
//		System.out.println(addressid+"==="+isdefault+"==="+name+"==="+tel+"==="+addr1+"==="+addr2);
		if (addressid!=null&&isdefault!=null&&tel!=null&&addr1!=null&&name!=null&&addr2!=null) {
			String[] addr=addr1.split("-");
			String province=addr[0];
			String city=addr[1];
			String village=addr[2];
			//通过session拿到用户的id
			HttpSession session =request.getSession();
			UserInfo info =(UserInfo) session.getAttribute("userinfo");
			int uid=info.getUser().getUid();
			//得到是否为默认值
			int isdfaul=Integer.parseInt(isdefault);
			//得到地址Id
			int addressId=Integer.parseInt(addressid);
			Address address=new Address();
			address.setAddressid(addressId);
			address.setCity(city);
			address.setDetail(addr2);
			address.setIsdefault(isdfaul);
			address.setName(name);
			address.setProvince(province);
			address.setTel(tel);
			address.setVillage(village);
			address.setUid(uid);
			Connection conn=DBConnection1.getConnection();
			try {
				conn.setAutoCommit(false);
				BaseDao dao=new BaseDaoImpl();
				ShopCurrentDao dao1=new ShopCurrentDaoImpl();
				//将所有默认值改为0
				boolean flag1= dao1.updateAllisdefault(conn, uid);
				boolean flag=dao.updateObjectById(conn, address);
				conn.commit();
				DBConnection1.close(conn);
				PrintWriter out=response.getWriter();
				JSONObject jo=new JSONObject();
				jo.put("ifUpdateAddrSuccess", flag);
				out.write(jo.toString());
				out.flush();
				out.close();
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
