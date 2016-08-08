package com.rain.service;

import com.rain.domain.Good;
import com.rain.util.Page;

/**
 * GoodService
 * */
public interface GoodService {
	/**
	 * 添加商品
	 * @param Good
	 * @return String
	 * */
	public boolean addGood(Good good);
	/**
	 * 删除商品
	 * @param id
	 * @return boolean
	 */
	public boolean deleteGood(int id);
	/**
	 * 查询所有商品
	 * @param good_code
	 * @param good_name
	 * @param pageNumber
	 * @return Page
	 * */
	public Page queryAllGood(String good_code,String good_name,String pageNumber,String url);
}
