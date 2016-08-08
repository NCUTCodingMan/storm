package com.rain.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rain.dao.LoginDao;
import com.rain.domain.User;
import com.rain.util.JDBCUtil;

public class LoginDaoImp implements LoginDao {
	private Connection conn;
	public boolean verifyUsernameAndPassword(User user) {
		this.conn = JDBCUtil.getInstance().getConnection();
		String queryUser = "select * from User where User_Name = ?";
		PreparedStatement ps;
		try{
			ps = conn.prepareStatement(queryUser);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			String password = rs.getString("User_Password");
			if(password.equals(user.getPassword())){
				return true;
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
