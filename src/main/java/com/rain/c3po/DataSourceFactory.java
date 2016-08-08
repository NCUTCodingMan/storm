package com.rain.c3po;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class DataSourceFactory {
	public static void main(String[] args) {
		DataSource ds_unpooled = null;
		DataSource ds_pooled = null;
		String url = "jdbc:mysql://127.0.0.1:3306/orcl";
		String user = "root";
		String password = "tiger";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			ds_unpooled = DataSources.unpooledDataSource(url,user,password);
			// 配置 使用Map来初始化配置信息
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("maxPoolSize", new Integer(10));
			params.put("maxStatements", "50");
			ds_pooled = DataSources.pooledDataSource(ds_unpooled,params);
			Connection conn = ds_pooled.getConnection();
			String queryUser = "select * from User";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(queryUser);
			rs.next();
			String name = rs.getString("User_Name");
			System.out.println(name);
			st.close();
			rs.close();
			conn.close();
			// 清除PooledDataSource
			DataSources.destroy(ds_pooled);
		}catch(Exception e){
			
		}
	}
}
