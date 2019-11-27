package com.lz.service.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.lz.dto.UserInfo;


/**
 * 单态登录监听器
 * @author sjh 
 *
 */
@WebListener
public class SingletStateLoginListener implements HttpSessionAttributeListener {
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	/**
	 * session添加属性
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		String userinfo = arg0.getName();
    	if("userinfo".equals(userinfo)){
    		UserInfo newu = (UserInfo) arg0.getValue();
    		if(map.get(newu.getUname())!=null){
    			HttpSession ss = map.get(newu.getUname());
    			UserInfo oldu = (UserInfo) ss.getAttribute("userinfo");
    			System.out.println("帐号" + oldu.getUname() + "在" + oldu.getIp() + "已经登录，该登录将被迫下线。");
    			ss.removeAttribute("userinfo");
    			map.remove(oldu.getUname());
    			ss.setAttribute("SingletStateLoginListenerMsg", "您的帐号已经在其他机器上登录，您被迫下线。");
    		}
    		
    		map.put(newu.getUname(), arg0.getSession());
    		
    	}
	}
	/**
	 * session移除属性
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String userinfo = arg0.getName();

		// 注销
		if (userinfo.equals("userinfo")) {
			UserInfo u = (UserInfo) arg0.getValue();
			map.remove(u.getUname());
			System.out.println("帐号" + u.getUname() + "注销。");
		}
	}
	/**
	 * session属性替换
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		String userinfo = arg0.getName();

		// 没有注销时，用另一个帐号登录
		if (userinfo.equals("userinfo")) {
			UserInfo oldu = (UserInfo) arg0.getValue();
			map.remove(oldu.getUname());
			UserInfo newu = (UserInfo) arg0.getSession().getAttribute("userinfo");

			// 检查新登录的帐号是否在别的机器上登录过
			if (map.get(newu.getUname()) != null) {
				HttpSession session = map.get(newu.getUname());
				session.removeAttribute("name");
				session.setAttribute("SingletStateLoginListenerMsg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}
			map.put(newu.getUname(), arg0.getSession());
		}
	}
}
