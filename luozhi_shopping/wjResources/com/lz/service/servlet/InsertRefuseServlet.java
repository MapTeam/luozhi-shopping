package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.dao.registDao;
import com.lz.dao.impl.registDaoImpl;

import net.sf.json.JSONObject;

@WebServlet("/InsertRefuseServlet")
public class InsertRefuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertRefuseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registDao dao =new registDaoImpl();
		String goid=request.getParameter("id");
		int id=Integer.parseInt(goid);
		
		String sta=request.getParameter("status");
		int status=Integer.parseInt(sta);

		String msg=request.getParameter("msg");
		boolean flag=dao.insertRefuseReasonById(msg, id,status);   
		JSONObject jo=new JSONObject().fromObject(flag);
		PrintWriter pw=response.getWriter();
		pw.write(jo.toString());
		pw.flush();
		pw.close();
	}

}
