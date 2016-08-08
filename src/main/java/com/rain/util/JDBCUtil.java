package com.rain.util;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	private static JDBCUtil jdbcUtil;
	private ComboPooledDataSource cpds;
	static{
		jdbcUtil = new JDBCUtil();
	}
	private JDBCUtil(){
		cpds = new ComboPooledDataSource();
	}
	
	public final static JDBCUtil getInstance(){
		return jdbcUtil;
	}
	
	public final Connection getConnection(){
		try{
			return cpds.getConnection();
		}catch(Exception e){
			throw new RuntimeException("获取连接失败");
		}
	}
}
