package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.impl.registDaoImpl;
import com.lz.pojo.User;
import com.lz.util.CreateCode;
import com.lz.util.MailSender;

import net.sf.json.JSONObject;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String email=(String) request.getParameter("email");
		   if(email!=null&&!"".equals(email)){
			   registDaoImpl res=new registDaoImpl();
			    User user=res.registSelectByEmail(email);
			 	PrintWriter out=response.getWriter();
		    	JSONObject obj = new JSONObject();
			    if(user!=null){
			    	MailSender sender=new MailSender();
			    	String code=new CreateCode().CreateVerifyCode();
			    	new Thread(new Runnable() {
						@Override
						public void run() {
							sender.sendFind(email, "LuoZhi", code);
						}
					}).start();
			    	request.getSession().setAttribute("findcode", code);
			    	request.getSession().setAttribute("email", email);
					obj.put("msg", true);
					out.write(obj.toString());
					out.flush();
					out.close();
			    	
			    }
			    else{
			    	obj.put("msg", false);
					out.write(obj.toString());
					out.flush();
					out.close();
			    }
			    
		   }else{
			   
		   }
           
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
