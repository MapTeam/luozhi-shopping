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

import com.lz.dao.impl.BaseDaoImpl;
import com.lz.dao.impl.GoodsColorDaoImpl;
import com.lz.dao.impl.IntroduceDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;
import com.lz.pojo.GoodsIntroduceImg;

/**
 * 商品详情
 * @author sjh
 *
 */
@WebServlet("/IntroudceServlet")
public class IntroudceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IntroudceServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		BaseDaoImpl dao = new BaseDaoImpl();
		IntroduceDaoImpl idao = new IntroduceDaoImpl();
		GoodsColorDaoImpl gcolordao = new GoodsColorDaoImpl();
		Goods goods = new Goods();
		goods.setGid(Integer.parseInt(gid));
		Connection conn = DBConnection1.getConnection();
		//查询相应的商品
		goods = (Goods) dao.selectObjectById(conn, goods);
		//查询相应的介绍
		GoodsIntroduceImg gii = idao.selectGoodsIntroduce(conn, Integer.parseInt(gid));
		//查询相应的颜色
		List<GoodsColor> gcolors = (List<GoodsColor>) gcolordao.selectColor(conn, Integer.parseInt(gid));
		DBConnection1.close(conn);
		String str = gii.getIntroduceImgs();
		String[] s = str.split(",");
		List<String> inimg = new ArrayList<String>();
		for (String string : s) {
			inimg.add(string);
		}
		String str1 = goods.getGpicture();
		String[] s1 = str1.split(",");
		List<String> lpimg = new ArrayList<String>();
		for (int i = 0; i < s1.length; i++) {
			if(i>3){
				break;
			}
			lpimg.add(s1[i]);
		}

		request.setAttribute("goods", goods);
		request.setAttribute("lpimg", lpimg);
		request.setAttribute("inimg", inimg);
		request.setAttribute("gcolors", gcolors);
		request.getRequestDispatcher("product_particular.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
