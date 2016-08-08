package com.rain.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rain.domain.Good;
import com.rain.service.GoodService;
import com.rain.serviceImp.GoodServiceImp;
import com.rain.util.Page;

/**
 * 如何动态的执行方法?
 * 直接在方法上声明Action即可
 * ParentPackage(value="struts")的value值往往设置为项目的配置文件,这样可以引入配置文件中
 * 声明的拦截器,异常以及全局结果
 * 个人比较喜欢配置文件配置
 * */
@SuppressWarnings("serial")
public class GoodAction extends ActionSupport {
	private GoodService goodService = new GoodServiceImp();
	private int id;
	private String goodCode;
	private String goodName;
	private float goodPrice;
	private String goodType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodCode() {
		return goodCode;
	}
	public void setGoodCode(String goodCode) {
		this.goodCode = goodCode;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public float getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(float goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	
	/**
	 * 添加商品
	 * @param void
	 * @return String
	 * @throws Exception
	 * */
	public String createGood() throws Exception{
		Good good = new Good();
		good.setGoodCode(goodCode);
		good.setGoodName(goodName);
		good.setGoodPrice(goodPrice);
		good.setGoodType(goodType);
		if(goodService.addGood(good)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 查询所有商品
	 * @param void
	 * @return String
	 * @throws Exception
	 * */
	public String queryAllGood() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		// 查询参数
		String good_code = request.getParameter("good_code");
		String good_name = request.getParameter("good_name");
		String pageNumber = request.getParameter("pageNumber");
		// 获取分页工具类
		Page page = this.goodService.queryAllGood(good_code,good_name,pageNumber,"viewGood.action");
		request.setAttribute("page", page);
		return SUCCESS;
	}
	
	/**
	 * 修改商品
	 * @return
	 * @throws Exception
	 */
	public String editGood() throws Exception{
		return null;
	}
	
	/**
	 * 删除商品
	 * @return
	 * @throws Exception
	 */
	public String deleteGood() throws Exception{
		if(this.id != 0){
			if(goodService.deleteGood(this.id)){
				return SUCCESS;
			}
		}
		return INPUT;
	}
}
