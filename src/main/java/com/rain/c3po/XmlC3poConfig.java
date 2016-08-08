package com.rain.c3po;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * 使用c3p0-config.xml配置
 * 比较特殊的是,里面可以配置多个数据源;并且在使用的时候可以切换
 * 	(使用ComboPooledDataSource的构造方法指定name信息即可)
 * */
public class XmlC3poConfig {
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
