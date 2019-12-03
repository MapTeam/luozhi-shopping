package com.lz.service.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.registDao;
import com.lz.dao.impl.registDaoImpl;
import com.lz.dto.GoodsOrderDto;
import com.lz.dto.GoodsOrdergoodDto;
import com.lz.dto.UserInfo;
import com.lz.util.FinalType;
/*
 * 用户订单
 */
@WebServlet("/UserOrderServlet")
public class UserOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registDao dao=new registDaoImpl();
		UserInfo ui=(UserInfo) request.getSession().getAttribute("userinfo");
		if (ui!=null) {
			int uid=ui.getUser().getUid();
			List<GoodsOrderDto> list=dao.selectUserOrderByStaAndUid(uid, FinalType.NOPAY);
			if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
					List<GoodsOrdergoodDto> list1 = dao.selectAllGoodsByOrSta(list.get(i).getGoid());
					list.get(i).setGogoods(list1);
				}
				
			}
			request.setAttribute("list",list);
			request.getRequestDispatcher("personal_order.jsp").forward(request, response);
		}else {
			response.sendRedirect("HomeServlet");
		}
		
	}

}
