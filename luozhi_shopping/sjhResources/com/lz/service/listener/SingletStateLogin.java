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
public class SingletStateLogin implements HttpSessionAttributeListener {
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	/**
	 * session添加属性
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		String userinfo = arg0.getName();
    	if("userinfo".equals(userinfo)){
    		UserInfo newu = (UserInfo) arg0.getValue();
    		if(map.get(newu.getName())!=null){
    			HttpSession ss = map.get(newu.getName());
    			UserInfo oldu = (UserInfo) ss.getAttribute("name");
    			System.out.println("帐号" + oldu.getName() + "在" + oldu.getIp() + "已经登录，该登录将被迫下线。");
    			ss.removeAttribute("name");
    			map.remove(oldu.getName());
    			ss.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
    		}
    		
    		map.put(newu.getName(), arg0.getSession());
    		
    	}
	}
	/**
	 * session移除属性
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}
	/**
	 * session属性替换
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}
}
