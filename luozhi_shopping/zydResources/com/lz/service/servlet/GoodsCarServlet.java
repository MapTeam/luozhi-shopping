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
import javax.websocket.Session;

import com.lz.dao.impl.GoodsCarDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.*;

import com.lz.dto.GoodsCarDTO;


/**
 * Servlet implementation class ShoppingCarServlet
 */
@WebServlet("/ShoppingCarServlet")
public class GoodsCarServlet extends HttpServlet {


    public GoodsCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
                		
//	        System.out.println();
//	       GoodsCarDaoImpl gcdi=new GoodsCarDaoImpl();
//		   Connection conn = DBConnection1.getConnection();
           HttpSession s=  request.getSession();
    
//           User user=(User)s.getAttribute("user");  
//           if(user!=null){
//           List<GoodsCarDTO> goodscardto=gcdi.getGoodsCarDTO(conn, user);
//           request.setAttribute("goodscardto", goodscardto);
//           System.out.println(goodscardto);
//           }else{
//        	   System.out.println("没有user");
//           }
//          
            
            
    
            
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
