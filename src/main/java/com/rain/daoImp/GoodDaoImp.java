package com.rain.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rain.dao.GoodDao;
import com.rain.domain.Good;
import com.rain.util.JDBCUtil;
import com.rain.util.Page;

public class GoodDaoImp implements GoodDao {
	private Connection conn;
	public boolean addGood(Good good) {
		conn = JDBCUtil.getInstance().getConnection();
		String insertGood = "insert into Good(Good_Code,Good_Name,Good_Price,Good_Type) values(?,?,?,?)";
		PreparedStatement ps;
		try{
			ps = conn.prepareStatement(insertGood);
			ps.setString(1, good.getGoodCode());
			ps.setString(2, good.getGoodName());
			ps.setFloat(3, good.getGoodPrice());
			ps.setString(4, good.getGoodType());
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			
		}
		return false;
	}
	public boolean deleteGood(int id) {
		String deleteGood = "delete from Good where Good_ID = ?";
		conn = JDBCUtil.getInstance().getConnection();
		PreparedStatement pst = null;
		try{
			pst = conn.prepareStatement(deleteGood);
			pst.setInt(1, id);
			if(pst.executeUpdate() > 0){
				return true;
			}
		}catch(Exception e){
			
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public Page queryAllGood(String good_code, String good_name,
			String pageNumber,String url) {
		String queryGood = "select count(*) from Good";
		conn = JDBCUtil.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;
		int totalRecord = 0;
		Page page = null;
		try{
			st = conn.createStatement();
			rs = st.executeQuery(queryGood);
			rs.next();
			totalRecord = rs.getInt(1);
		}catch(Exception e){
			
		}
		if((good_code == null || good_code.trim() == "") && 
			(good_name == null || good_name.trim() == "")){
			int queryPage = 1;
			if(pageNumber != null){
				queryPage = Integer.valueOf(pageNumber);
			}
			page = new Page(queryPage,totalRecord);
			page.setUrl(url);
			page.setList(new ArrayList<Good>());
			queryGood = "select * from Good limit " + page.getStartIndex() + "," + page.getPageSize();
			try {
				rs = st.executeQuery(queryGood);
				while(rs.next()){
					Good good = new Good();
					good.setGoodId(rs.getInt("Good_ID"));
					good.setGoodCode(rs.getString("Good_Code"));
					good.setGoodName(rs.getString("Good_Name"));
					good.setGoodPrice(rs.getFloat("Good_Price"));
					good.setGoodType(rs.getString("Good_Type"));
					page.getList().add(good);
				}
				rs.close();
				st.close();
				conn.close();
				return page;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}