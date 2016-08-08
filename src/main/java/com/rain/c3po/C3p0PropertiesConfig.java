package com.rain.c3po;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * c3p0.properties
 * 创建的ds_pool = DataSources.pooledDataSource(ds_unpool)会默认的去读取c3p0.properties配置
 * 信息,此种配置方法较一般的properties简单
 * */
public class C3p0PropertiesConfig {
	public static void main(String[] args) {
		DataSource ds_unpool = null;
		DataSource ds_pool = null;
		Connection conn = null;
		try{
			ds_unpool = DataSources.unpooledDataSource();
			ds_pool = DataSources.pooledDataSource(ds_unpool);
			conn = ds_pool.getConnection();
			String queryUser = "select * from User";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(queryUser);
			rs.next();
			String name = rs.getString("User_Name");
			System.out.println(name);
			st.close();
			rs.close();
			conn.close();
			DataSources.destroy(ds_pool);
		}catch(Exception e){
			
		}
	}
}
