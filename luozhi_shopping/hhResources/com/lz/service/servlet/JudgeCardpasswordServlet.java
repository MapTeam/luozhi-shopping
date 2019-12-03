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
 * 判断银行卡密码是否正确以及金额是否能够支付
 */
@WebServlet("/JudgeCardpasswordServlet")
public class JudgeCardpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JudgeCardpasswordServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countname=request.getParameter("countname");
		String countpass=request.getParameter("countpass");
		String money=request.getParameter("money");
//		System.out.println(countname+"==="+countpass+"===="+money);
		if (countname!=null&&countpass!=null&&money!=null) {
			double mon=Double.parseDouble(money);
			Bank bank=new BankProxy();
			ReturnMsg rmsg=bank.transferAccounts(countname, countpass, "6217002990107872941", mon);
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
