package com.rain.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义标签处理器,此类的形式与javabean比较像,提供属性的get/set方法
 * 在页面中设置属性值会注入进来
 * 创建自定义标签程序的5个步骤
 * (1) 创建标签处理器,这里可以继承JspTag接口的默认实现类,如TagSupport,SimpleTagSupport
 * (2) 编写标签描述文件,该文件常常以tld结尾,表现为xml文件;描述标签名称,属性等等
 * (3) 在web.xml中指定标签库的引用
 * (4) 在jsp页面中引入,并使用标签即可
 * */
@SuppressWarnings("serial")
public class Myfront extends TagSupport {
	private String bgColor = "#f5f5f5";
	private String color = "#f5f5f5";
	private String align = "center";
	public String getBgColor() {
		return bgColor;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	/**
	 * 重写TagSupport中的doStartTag()
	 * 当jsp页面碰到标签的开头的时候就会执行doStartTag(),该函数返回EVAL_BODY_INCLUDE与SKIP_BODY
	 * EVAL_BODY_INCLUDE表示将显示标签间的文字
	 * SKIP_BODY后者表示不显示标签间的文字；
	 * */
	@Override
	public int doStartTag() throws JspException {
		/** 
		 * pageContext页面上下文,代表着当前页面运行的一些属性.所有的内置对象
		 * 都可以从pageContext中得出.
		 */
		JspWriter out = pageContext.getOut();
		try{
			out.print("<div>" + this.align + this.bgColor + this.color + "</div>");
		}catch(Exception e){
			
		}
		return EVAL_BODY_INCLUDE;
	}
	/**
	 * 当jsp页面碰到标签的结尾的时候就会指定doEndTag(),返回返回值是EVAL_PAGE 与 SKIP_PAGE
	 * EVAL_PAGE表示jsp页面正常执行
	 * SKIP_PAGE表示不处理接下来的JSP网页
	 * */
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}