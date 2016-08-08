package com.rain.c3po;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

/**
 * 使用ResourceBundle以及c3p0_zh_CN.properties配置数据库连接池
 * 此种方式配置c3p0比较繁琐,都是通过get/set方式覆盖默认的配置信息
 * */
public class PropertiesConfigC3p0 {
	public static void main(String[] args) {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		ResourceBundle rb = ResourceBundle.getBundle("c3p0",Locale.CHINA);
		Connection conn = null;
		try{		
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/orcl");
			dataSource.setUser("root");
			dataSource.setPassword("tiger");
			dataSource.setInitialPoolSize(Integer.valueOf(rb.getString("c3p0.initialPoolSize")));
			dataSource.setMinPoolSize(Integer.valueOf(rb.getString("c3p0.minPoolSize")));
			dataSource.setMaxPoolSize(Integer.valueOf(rb.getString("c3p0.maxPoolSize")));
			dataSource.setMaxStatements(Integer.valueOf(rb.getString("c3p0.maxStatements")));
			dataSource.setMaxIdleTime(Integer.valueOf(rb.getString("c3p0.maxIdleTime")));
			conn = dataSource.getConnection();
			String queryUser = "select * from User";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(queryUser);
			rs.next();
			String name = rs.getString("User_Name");
			System.out.println(name);
			st.close();
			rs.close();
			conn.close();
			DataSources.destroy(dataSource);
		}catch(Exception e){
			
		}
	}
}
