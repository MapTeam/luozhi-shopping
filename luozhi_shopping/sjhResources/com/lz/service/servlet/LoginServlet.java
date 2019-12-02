package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.ShopCarNumDao;
import com.lz.dao.impl.LoginDaoImpl;
import com.lz.dao.impl.ShopCarNumDaoImpl;
import com.lz.db.DBConnection1;
import com.lz.dto.UserInfo;
import com.lz.pojo.User;
import com.lz.util.Md5;

import net.sf.json.JSONObject;
/**
 * 登录的sevlet
 * @author sjh
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取登录名与密码
		String uname = request.getParameter("username");
		String upwd = request.getParameter("password");
		//是否保存密码
		String savepassword = request.getParameter("savepassword");
		if(uname!=null&&!"".equals(uname)&&upwd!=null&&!"".equals(upwd)&&savepassword!=null&&!"".equals(savepassword)){
			//new 一个登录的dao
			LoginDaoImpl ldao = new LoginDaoImpl();
			ShopCarNumDao scndao=new ShopCarNumDaoImpl();
			Connection conn = DBConnection1.getConnection();
			User u = ldao.login(conn, uname, Md5.md5(upwd));
			int shopcarnum = 0;
			if(u!=null){
				shopcarnum=scndao.selectShopCardNumDao(conn, u.getUid());
			}
			DBConnection1.close(conn);			
			PrintWriter out = response.getWriter();
			if(u==null){
				//如果用户输入的密码或用户名不正确就向客户端响应一个json {"code":1001,"loginmsg":"账号或密码错误"}
				JSONObject jsonobj = new JSONObject();
				jsonobj.put("code", 1001);
				jsonobj.put("loginmsg", "账号或密码错误");
				out.write(jsonobj.toString());
				out.flush();
				out.close();
			}else{
				//将密码与用户名存到cookie
				if("true".equals(savepassword)){
					Cookie unamecookie = new Cookie("uname", URLEncoder.encode(uname,"UTF-8"));
					unamecookie.setMaxAge(7*24*60);
					Cookie upwdcookie = new Cookie("upwd", URLEncoder.encode(upwd,"UTF-8"));
					upwdcookie.setMaxAge(7*24*60);
					response.addCookie(unamecookie);
					response.addCookie(upwdcookie);
				}else{
					Cookie unamecookie = new Cookie("uname", URLEncoder.encode(uname,"UTF-8"));
					unamecookie.setMaxAge(0);
					Cookie upwdcookie = new Cookie("upwd", URLEncoder.encode(upwd,"UTF-8"));
					upwdcookie.setMaxAge(0);
					response.addCookie(unamecookie);
					response.addCookie(upwdcookie);
				}
				
				//如果用户输入的密码或用户名不正确就向客户端响应一个json {"code":1000,"loginmsg":"成功"}
				UserInfo uinfo = new UserInfo();
				uinfo.setUname(u.getUname());
				uinfo.setUser(u);
				uinfo.setIp(request.getRemoteAddr());
				uinfo.setDate(new Date());
				uinfo.setShopcargoodsnum(shopcarnum);
				request.getSession().setAttribute("userinfo", uinfo);
				JSONObject jsonobj = new JSONObject();
				jsonobj.put("code", 1000);
				jsonobj.put("loginmsg", "成功");
				out.write(jsonobj.toString());
				out.flush();
				out.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
