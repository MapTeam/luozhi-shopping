package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

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
 *在订单块添加新地址
 */
@WebServlet("/AddNewAddressServlet")
public class AddNewAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddNewAddressServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isdefault=request.getParameter("isdefault");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
//		System.out.println(isdefault+"==="+name+"==="+tel+"==="+addr1+"==="+addr2);
		if (isdefault!=null&&tel!=null&&addr1!=null&&name!=null&&addr2!=null) {
			//通过字符串的拆分将省市区分开
			String[] addr=addr1.split("-");
			String province=addr[0];
			String city=addr[1];
			String village=addr[2];
			//通过session拿到用户的id
			HttpSession session =request.getSession();
			UserInfo info =(UserInfo) session.getAttribute("userinfo");
			
			if (info!=null) {
				int uid=info.getUser().getUid();
				//得到是否为默认值
				int isdfaul=Integer.parseInt(isdefault);
				Connection conn=DBConnection1.getConnection();
				if (isdfaul==1) {
					ShopCurrentDao updatedao=new ShopCurrentDaoImpl();
					boolean updateflag=updatedao.updateAllisdefault(conn, uid);
//					System.out.println(updateflag);
				}
				Address address=new Address();
				address.setCity(city);
				address.setDetail(addr2);
				address.setIsdefault(isdfaul);
				address.setName(name);
				address.setProvince(province);
				address.setTel(tel);
				address.setVillage(village);
				address.setUid(uid);
				BaseDao dao=new BaseDaoImpl();
				boolean flag=dao.insertObject(conn, address);
				DBConnection1.close(conn);
				PrintWriter out=response.getWriter();
				JSONObject jo=new JSONObject();
				jo.put("ifAddAddrSuccess", flag);
				out.write(jo.toString());
				out.flush();
				out.close();
			}
			
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
