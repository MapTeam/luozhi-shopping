package com.lz.service.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.CarGoodsOrderDaoImpl;
import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.CarOrderInputGoods;
import com.lz.dto.OrderInputByCar;
import com.lz.dto.UserInfo;
import com.lz.pojo.Address;
import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;
import com.lz.pojo.GoodscarGoods;

/**
 * 购物车提交多条商品的订单
 * @author sjh
 *
 */
@WebServlet("/CarGoodsOrderServlet")
public class CarGoodsOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarGoodsOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		UserInfo userinfo=(UserInfo) s.getAttribute("userinfo");
		if (userinfo!=null) {
		String str = request.getParameter("str");
		if(str!=null&&!"".equals(str)&&userinfo!=null){
			OrderInputByCar oibc = new OrderInputByCar();
			CarGoodsOrderDaoImpl cgodao = new CarGoodsOrderDaoImpl();
			Connection conn = DBConnection1.getConnection();
			String[] string = str.split(",");
			List<Integer> gcgids = new ArrayList<Integer>();
			for (String string2 : string) {
				gcgids.add(Integer.parseInt(string2));
			}
			List<CarOrderInputGoods> coigs = cgodao.selectOrderInputGood(conn, gcgids);
			int toalCount = 0;
			float toalPrice = 0;
			for (CarOrderInputGoods carOrderInputGoods : coigs) {
				toalCount+=carOrderInputGoods.getGoodscount();
				toalPrice+=(carOrderInputGoods.getGoodscount()*carOrderInputGoods.getGoods().getGprice());
			}
			List<Address> addresslist = cgodao.selectUserAddressByUid(conn, userinfo.getUser().getUid());
			DBConnection1.close(conn);
			request .setAttribute("toalCount", toalCount);
			request .setAttribute("toalPrice", toalPrice);
			request .setAttribute("coigs", coigs);
			request .setAttribute("addresslist", addresslist);
			request.getRequestDispatcher("order.jsp").forward(request, response);
		} else {
			System.out.println("传的参数有误");
		}
		}else {
			response.sendRedirect("HomeServlet");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
