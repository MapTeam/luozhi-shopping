package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.util.CreateCode;
import com.lz.util.MailSender;

import net.sf.json.JSONObject;
/**
 * 
 * @author sjh
 *
 */
@WebServlet("/CreateCodeServlet")
public class CreateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
//		System.out.println(email);
		PrintWriter out = response.getWriter();
		if(email!=null&&!"".equals(email)){
			String code = CreateCode.CreateVerifyCode();
			new Thread(new Runnable() {
				public void run() {
					MailSender.send(email, "LuoZhi", code);
				}
			}).start();
			request.getSession().setAttribute("Registemail", email);
			request.getSession().setAttribute("Registcode", code);
			JSONObject obj = new JSONObject();
			obj.put("RegistFlag", true);
			out.write(obj.toString());
			out.flush();
			out.close();
		}else{
			JSONObject obj = new JSONObject();
			obj.put("RegistFlag", false);
			out.write(obj.toString());
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
