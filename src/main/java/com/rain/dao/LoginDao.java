package com.rain.dao;

import com.rain.domain.User;

public interface LoginDao {
	public boolean verifyUsernameAndPassword(User user);
}
