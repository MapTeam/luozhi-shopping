package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import net.sf.json.JSONArray;

/*
 * 用户通过Ajax得到数据
 */
@WebServlet("/UserOrderByUid")
public class UserOrderByUid extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserOrderByUid() {
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
			List<GoodsOrderDto> list=dao.selectUserOrderByuid(uid);
			if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
					List<GoodsOrdergoodDto> list1 = dao.selectAllGoodsByOrSta(list.get(i).getGoname());
					list.get(i).setGogoods(list1);
				}
				
			}
			JSONArray jarr=new JSONArray().fromObject(list);
			PrintWriter pw=response.getWriter();
			pw.write(jarr.toString());
			pw.flush();
			pw.close();
		}else {
			response.sendRedirect("HomeServlet");
		}
		
		}
	}

