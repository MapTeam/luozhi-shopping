package com.lz.service.servlet;
/**
 * 点击立即购买
 */
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.dao.ShopCurrentDao;
import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.OrderInput;
import com.lz.dto.OrderInputGoods;
import com.lz.dto.UserInfo;
import com.lz.pojo.Address;

@WebServlet("/ShopCurrentServlet")
public class ShopCurrentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShopCurrentServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		UserInfo userinfo=(UserInfo) s.getAttribute("userinfo");
		if (userinfo!=null) {
			
			String gcid=request.getParameter("gcolorid");
			String userid=request.getParameter("userid");
			String goodscount=request.getParameter("goodscount");
			if (!"".equals(gcid)&&gcid!=null&&!"".equals(userid)&&userid!=null&&!"".equals(goodscount)&&goodscount!=null) {
				//将得到的数据转换为int形式
				int gcolorid=Integer.parseInt(gcid);
				int uid=Integer.parseInt(userid);
				int gcount=Integer.parseInt(goodscount);
				//调用dao层的两个方法：1、根据商品颜色id查找出这个商品的这个颜色分类所有内容  2、根据用户id查找出这个用户的所有地址
				ShopCurrentDao dao=new ShopCurrentDaoImpl();
				Connection conn=DBConnection1.getConnection();
				OrderInputGoods oig=dao.selectGoodsInformationByGcolorid(conn, gcolorid);
				List<Address> addresslist =dao.selectUserAddressByUid(conn, uid);
				DBConnection1.close(conn);
				OrderInput oi = new OrderInput();
				oi.setAddresslist(addresslist);
				oi.setGoodscount(gcount);
				oi.setOrderinputgoods(oig);
				request .setAttribute("oi", oi);
				request.getRequestDispatcher("order.jsp").forward(request, response);
//				System.out.println(oig.getGoods().toString()+oig.getGoodscolor().toString());
				
			}
		}else {
			response.sendRedirect("HomeServlet");
		}
			
//			System.out.println("颜色id"+gcolorid+"用户id"+userid+"选择的数量"+goodscount);
//			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
