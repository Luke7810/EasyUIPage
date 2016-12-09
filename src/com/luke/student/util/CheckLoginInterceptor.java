package com.luke.student.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor{
	public static final String LOGIN_KEY = "admin";  
    public static final String LOGIN_PAGE = "welcome";
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("begin check login interceptor!"); 
		
		// 对LoginAction不做该项拦截  
        String actionName = actionInvocation.getProxy().getActionName();
        System.out.println("********actionName: "+ actionName);
        if ("loginAction".equals(actionName) || "welcome".equals(actionName)) {  
            System.out.println("exit check login, because this is login action.");  
            return actionInvocation.invoke();  
        }
        
        // 确认Session中是否存在LOGIN  
        Map session = actionInvocation.getInvocationContext().getSession();  
        String login = (String) session.get(LOGIN_KEY);  
        if (login != null && login.length() > 0) {  
        	// 存在的情况下进行后续操作。  
            System.out.println("already login!");  
            return actionInvocation.invoke();
        }else{
        	// 否则终止后续操作，返回LOGIN  
            System.out.println("no login, forward login page!");  
            return "mainpage"; 
        }
	}

}
