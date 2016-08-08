package com.rain.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rain.domain.User;
import com.rain.service.LoginService;
import com.rain.serviceImp.LoginServiceImp;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private LoginService loginService = new LoginServiceImp();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 简单的输入验证
	@Override
	public void validate(){
		if(username == null || (username.trim()).length() > 12){
			this.addFieldError("username", "用户名不合法");
		}
		if(password == null || (password.trim()).length() > 12 || (password.trim()).length() < 4){
			this.addFieldError("password", "密码不合法");
		}
	}
	
	// 判断用户名,密码是否正确
	public String execute(){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(loginService.isLogin(user)){
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("user", user);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
