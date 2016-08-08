package com.rain.serviceImp;

import com.rain.dao.LoginDao;
import com.rain.daoImp.LoginDaoImp;
import com.rain.domain.User;
import com.rain.service.LoginService;

public class LoginServiceImp implements LoginService {
	private LoginDao loginDao = new LoginDaoImp();
	public boolean isLogin(User user) {
		return loginDao.verifyUsernameAndPassword(user);
	}

}
