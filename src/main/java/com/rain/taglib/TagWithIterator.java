package com.rain.taglib;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport ;

/**
 * 简单的迭代器标签处理器,将页面传来的Collection通过"反射",获取setIterator(Collection<?> c)
 * 初始化it,当然name与type一样也会被初始化;初始化之后,执行doStartTag(),返回EVAL_BODY_INCLUDE
 * 之后执行doAfterBody(),在pageContext中存放Employee对象,循环标签体内容;取出对象的属性值
 * 这里private类型的属性值也可以取出来.这里使用到了EL表达式(还不是特别清楚原理)
 * */
@SuppressWarnings("serial")
public class TagWithIterator extends BodyTagSupport {
	private String name;
	private Iterator<?> it;
	private String type;
	public void setIterator(Collection<?> c){
		if(c.size() != 0){
			it = c.iterator();
		}
	}
	public void setName(String name){
		this.name = name;
	}
	public void setType(String type){
		this.type = type;
	}
	@Override
	public int doStartTag() throws JspException {
		if(this.it == null){
			return SKIP_BODY;
		}else{
			return prepareAfterBody();
		}
	}
	@Override
	public int doAfterBody() throws JspException {
		return continueNext(it);
	}
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	// 设置pageContext
	public int continueNext(Iterator<?> it){
		if(it.hasNext()){
			System.out.println("add Employee to pageContext");
			pageContext.setAttribute(name, it.next(), PageContext.PAGE_SCOPE);
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;
		}
	}
	// 预处理
	public int prepareAfterBody(){
		if(it.hasNext()){
			System.out.println("prepareAfterBody()");
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}
}