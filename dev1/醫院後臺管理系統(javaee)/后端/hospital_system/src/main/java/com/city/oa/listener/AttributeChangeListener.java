package com.city.oa.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationAttributeChangeListener
 *
 */
@WebListener
public class AttributeChangeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public AttributeChangeListener() {
        // TODO Auto-generated constructor stub
    }

 /**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         
     ServletContext  application =event.getServletContext();
     String name=event.getName();
     Object value=event.getValue();
     System.out.print("Application对象增加了属性"+name+"="+value);
    }

 /**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
     ServletContext  application =event.getServletContext();
        String name=event.getName();
        Object value=event.getValue();
        System.out.print("Application对删除了属性"+name+"="+value);
    }

 /**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }
 
}