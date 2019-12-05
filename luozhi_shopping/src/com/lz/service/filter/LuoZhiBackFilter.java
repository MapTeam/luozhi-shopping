package com.lz.service.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.pojo.Admincount;
/**
 * 后台拦截
 * @author sjh
 *
 */
public class LuoZhiBackFilter implements Filter {

    public LuoZhiBackFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Admincount admin = (Admincount) req.getSession().getAttribute("admin");
		if(admin!=null){
			chain.doFilter(request, response);
		}else{
			res.sendRedirect("/luozhi_shopping/AdminLogin.do");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
