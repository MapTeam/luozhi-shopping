package com.lz.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dto.ReturnMsg;
import com.bank.service.Bank;
import com.bank.service.BankProxy;

import net.sf.json.JSONObject;

/**
 * 判断银行账户是否存在
 */
@WebServlet("/JudgeCardNumServlet")
public class JudgeCardNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JudgeCardNumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardnum=request.getParameter("countname");
//		System.out.println(cardnum);
		if (cardnum!=null&&!"".equals(cardnum)) {
			Bank bank=new BankProxy();
			ReturnMsg rmsg = bank.verifyBankAccount(cardnum);
			
				JSONObject jo=new JSONObject().fromObject(rmsg);
				PrintWriter out=response.getWriter();
				out.write(jo.toString());
				out.flush();
				out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
