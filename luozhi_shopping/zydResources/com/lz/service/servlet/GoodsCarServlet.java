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

import com.lz.dao.impl.GoodsCarDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.GoodsCarDTO;
import com.lz.dto.UserInfo;
import com.lz.pojo.User;


@WebServlet("/ShoppingCarServlet")
public class GoodsCarServlet extends HttpServlet {


    public GoodsCarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       GoodsCarDaoImpl gcdi = new GoodsCarDaoImpl();
 		   Connection conn = DBConnection1.getConnection();
           HttpSession s =  request.getSession();   
           UserInfo userinfo = (UserInfo)s.getAttribute("userinfo");
           if(userinfo!=null){
        	   User user = (User)userinfo.getUser();
	           List<GoodsCarDTO> goodscardto = gcdi.getGoodsCarDTO(conn, user);
	           DBConnection1.close(conn);
	           s.setAttribute("goodscardto", goodscardto);
	           if (goodscardto.size()!=0) {
	        	   s.setAttribute("goodscarIsNotNull","yes");
	           }
               request.getRequestDispatcher("shopCar.jsp").forward(request,response);         
           }else{
        	   response.sendRedirect("HomeServlet");
           }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
