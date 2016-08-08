package com.rain.util;

import java.util.List;

/**
 * 分页相关工具类
 * */
public class Page {
	private int pageSize = 9;	// 每页显示9条数据
	private int startIndex;		// 记录开始索引
	private int totalRecord;	// 总记录数
	private int pageNumber;		// 想看的页面数
	private String url;			// 记录访问的action
	private int totalPage;		// 总页数
	private int startPage;		// 起始页
	private int endPage;		// 结束页
	private List list;		// 存放查询结果容器
	public Page(int pageNumber,int totalRecord){
		this.totalRecord = totalRecord;
		if(this.totalRecord % 9 != 0){
			this.totalPage = this.totalRecord / 9 + 1;
		}else{
			this.totalPage = this.totalRecord % 9;
		}
		if(pageNumber == 1){
			this.startIndex = 0;
			this.pageNumber = 1;
			this.startPage = 1;
			this.endPage = this.totalPage;
			if(this.endPage > 10){
				this.endPage = 10;
			}
		}else if(pageNumber > 1){
			this.pageNumber = pageNumber;
			this.startIndex = (pageNumber - 1) * pageSize;
			this.startPage = pageNumber - 5;
			if(this.startPage <= 0){
				this.startPage = 1;
			}
			this.endPage = this.startPage + 9;
			if(this.endPage > this.totalPage){
				this.endPage = this.totalPage;
			}
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String toString(){
		return "Page[(pageSize = " + this.pageSize + "),(startIndex = " + this.startIndex
				+ "),(totalRecord = " + this.totalRecord + "),(pageNumber = " + this.pageNumber
				+ "),(url = " + this.url + "),(totalPage = " + this.totalPage  
				+ "),(startPage = " + this.startPage + "),(endPage = " + this.endPage + ")]";
	}
	public static void main(String[] args) {
		Page page = new Page(1,20);
		System.out.println(page);
	}
}
