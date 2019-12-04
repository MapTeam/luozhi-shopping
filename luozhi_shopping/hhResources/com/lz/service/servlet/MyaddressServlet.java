package com.lz.service.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.dao.AddressDao;
import com.lz.dao.ShopCurrentDao;
import com.lz.dao.impl.AddressDaoImpl;
import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;
import com.lz.pojo.Address;

/**
 * 个人地址
 */
@WebServlet("/MyaddressServlet")
public class MyaddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyaddressServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userinfo");
		if (userinfo!=null){
			int uid=userinfo.getUser().getUid();
			Connection conn=DBConnection1.getConnection();
//			通过用户id查该用户的所有地址
			ShopCurrentDao dao=new ShopCurrentDaoImpl();
			AddressDao adao=new AddressDaoImpl();
			List<Address> addrlist=dao.selectUserAddressByUid(conn, uid);
			if (addrlist.size()==1) {
				int liaddrid=addrlist.get(0).getAddressid();
				adao.insertFirstDefault(conn, liaddrid);
				addrlist.get(0).setIsdefault(1);
			}
			DBConnection1.close(conn);
			request.setAttribute("addrlist", addrlist);
			request.getRequestDispatcher("myaddress.jsp").forward(request, response);
			
		}else{
			response.sendRedirect("HomeServlet");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
