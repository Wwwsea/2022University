package com.city.oa.listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.service.ISystemService;
import com.google.protobuf.Empty;

/**
 * 前端服务器的启动
 */
@WebListener
public class ServerStartListener implements ServletContextListener {

	private ISystemService ss=ServiceFactory.createSystemService();
   
	

	/**
     * 监听服务器的启动，自动发送邮件给系统管理员
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
    		ss.sendMail("wy2667657399@126.com", "服务器启动通知","服务器刚刚启动，请检查后台REST服务是否正常");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    		ss.sendMail("wy2667657399@126.com", "服务器停止警告","服务器刚刚停止，请立即处理");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
         
    }
    
}
