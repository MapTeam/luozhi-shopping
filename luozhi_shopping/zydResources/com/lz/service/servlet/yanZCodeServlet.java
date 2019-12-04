package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
/**
 * 验证邮件的验证码
 * @author Administrator
 *
 */
@WebServlet("/yanZCodeServlet")
public class yanZCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public yanZCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String scode = (String) request.getSession().getAttribute("findcode");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		if(code!=null&&!"".equals(code)){
			if(code.equals(scode)){
				String e1 = request.getParameter("email");
				String e2 = (String) request.getSession().getAttribute("email");
				//System.out.println(e1+"===="+e2);
				if(e1!=null&&e1.equals(e2)){
					//System.out.println(11);
					request.getSession().removeAttribute("findcode");
					obj.put("yanZFlag", true);
					obj.put("yanZMsg", "成功！");
				}else{
					obj.put("yanZFlag", false);
					obj.put("yanZMsg", "邮件不能更改！");
				}
			}else{
				obj.put("yanZFlag", false);
				obj.put("yanZMsg", "验证码不正确！");
			}
		}else{
			obj.put("yanZFlag", false);
			obj.put("yanZMsg", "输入为空！");
		}
		out.write(obj.toString());
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
