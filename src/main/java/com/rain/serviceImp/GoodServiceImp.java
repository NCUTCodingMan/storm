package com.rain.serviceImp;

import com.rain.dao.GoodDao;
import com.rain.daoImp.GoodDaoImp;
import com.rain.domain.Good;
import com.rain.service.GoodService;
import com.rain.util.Page;

public class GoodServiceImp implements GoodService {
	private GoodDao goodDao = new GoodDaoImp();
	// 添加商品
	public boolean addGood(Good good) {
		return goodDao.addGood(good);
	}
	// 删除商品
	public boolean deleteGood(int id) {
		return goodDao.deleteGood(id);
	}
	// 查询所有商品
	public Page queryAllGood(String good_code, String good_name,
			String pageNumber,String url) {		
		return goodDao.queryAllGood(good_code,good_name,pageNumber,url);
	}
}
