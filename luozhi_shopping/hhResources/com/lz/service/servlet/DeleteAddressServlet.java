package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lz.dao.AddressDao;
import com.lz.dao.BaseDao;
import com.lz.dao.ShopCurrentDao;
import com.lz.dao.impl.AddressDaoImpl;
import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;
import com.lz.pojo.Address;
import com.lz.pojo.User;

import net.sf.json.JSONObject;

/**
 * 删除地址
 */
@WebServlet("/DeleteAddressServlet")
public class DeleteAddressServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(DeleteAddressServlet.class);
	private static final long serialVersionUID = 1L;
    public DeleteAddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addrid=request.getParameter("addressid");
		if (addrid!=null&&!"".equals(addrid)) {
			//将地址的id转化为int类型
			int addressid=Integer.parseInt(addrid);
			//得到uid
			UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userinfo");
			int uid=userinfo.getUser().getUid();
			Address address=new Address();
			address.setAddressid(addressid);
			User user=new User();
			user.setUid(uid);
			Connection conn=DBConnection1.getConnection();
			try {
				conn.setAutoCommit(false);
				BaseDao dao=new BaseDaoImpl();
				Address addr=(Address) dao.selectObjectById(conn, address);
				ShopCurrentDao scdao=new ShopCurrentDaoImpl();
				AddressDao adao=new AddressDaoImpl();
				boolean flag1=dao.deleteObjectById(conn,address);
				boolean flag2=false;
				if (addr.getIsdefault()!=null&&addr.getIsdefault()==1) {
					List<Address> list =scdao.selectUserAddressByUid(conn, uid);
					if (list.size()>0) {
						int liaddrid=list.get(0).getAddressid();
						flag2=adao.insertFirstDefault(conn, liaddrid);
						if (flag1&&flag2) {
							PrintWriter out=response.getWriter();
							JSONObject jo=new JSONObject();
							jo.put("ifRemoveAddrSuccess", true);
							out.write(jo.toString());
							out.flush();
							out.close();
						}
					}else{
						if (flag1) {
							PrintWriter out=response.getWriter();
							JSONObject jo=new JSONObject();
							jo.put("ifRemoveAddrSuccess", true);
							out.write(jo.toString());
							out.flush();
							out.close();
						}
					}
				}else {
					if (flag1) {
						PrintWriter out=response.getWriter();
						JSONObject jo=new JSONObject();
						jo.put("ifRemoveAddrSuccess", true);
						out.write(jo.toString());
						out.flush();
						out.close();
					}
					
				}
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					log.error(e);
				}
			}finally {
				DBConnection1.close(conn);
			}
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
