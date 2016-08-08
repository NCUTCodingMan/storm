package com.rain.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.rain.action.LoginAction;

/**
 * 登录拦截器
 * */
@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {
	// 根据session信息,判断用户是否登录系统
	@Override
	@SuppressWarnings("rawtypes")
	public String intercept(ActionInvocation invocation) throws Exception {
		// 如果是登录系统,则不拦截,直接登录
		if(invocation.getAction().getClass() == LoginAction.class){
			return invocation.invoke();
		}
		Map session = invocation.getInvocationContext().getSession();
		if(session.get("user") == null){
			return Action.LOGIN;
		}
		return invocation.invoke();
	}
	
}
