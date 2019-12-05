package com.lz.service.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 加载配置
 * @author sjh
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	//加载防注入文件
    	InputStream in = ApplicationListener.class.getClassLoader().getResourceAsStream("zhuru.properties");
    	Properties p = new Properties();
    	try {
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	arg0.getServletContext().setAttribute("zhuru", p);
//    	System.out.println(p.get("str1"));
    }
	
}
