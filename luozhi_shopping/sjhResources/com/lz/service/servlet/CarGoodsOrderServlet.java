package com.lz.service.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.ShopCurrentDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.OrderInputByCar;

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
		String str = request.getParameter("str");
		if(str!=null&&!"".equals(str)){
			OrderInputByCar oibc = new OrderInputByCar();
			ShopCurrentDaoImpl sdao = new ShopCurrentDaoImpl();
			Connection conn = DBConnection1.getConnection();
			String[] string = str.split(",");
			for (String string2 : string) {
//				sdao.selectGoodsInformationByGcolorid(conn, gcolorid);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
