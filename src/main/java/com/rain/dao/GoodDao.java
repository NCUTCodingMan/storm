package com.rain.dao;

import com.rain.domain.Good;
import com.rain.util.Page;

public interface GoodDao {
	public boolean addGood(Good good);
	public boolean deleteGood(int id);
	public Page queryAllGood(String good_code,String good_name,String pageNumber,String url);
}
