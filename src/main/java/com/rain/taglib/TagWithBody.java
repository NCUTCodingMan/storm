package com.rain.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 设置带标签体的标签处理器
 * TagSupport与BodyTagSupport
 * 	TagSupport与BodyTagSupport的区别主要是标签处理类是否需要与标签体交互
 * 	如果不需要交互的就用TagSupport,否则如果不需要交互就用BodyTagSupport
 * 	交互就是标签处理类是否要读取标签体的内容和改变标签体返回的内容
 * */
@SuppressWarnings("serial")
public class TagWithBody extends BodyTagSupport {
	// 设置循环的次数
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 标签开始,当返回EVAL_BODY_INCLUDE时,默认的会执行doInitBody()与setBodyContent()
	 * 然后执行doAfterBody();只要doAfterBody()不返回SKIP_BODY,则会一直执行doAfterBody()
	 * 直到返回SKIP_BODY时,才会去执行doEndTag
	 * 有一点迭代器的影子
	 * */
	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		if(this.count > 0){
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}
	
	/**
	 * doAfterBody()返回值有EVAL_BODY_AGAIN与SKIP_BODY
	 * EVAL_BODY_AGAIN表示再显示一次标签间的文字
	 * SKIP_BODY表示继续执行标签处理的下一步
	 * */
	@Override
	public int doAfterBody() throws JspException {
		System.out.println("doAfterBody()");
		if(this.count > 0){
			-- this.count;
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag");
		if(this.bodyContent != null){
			try {
				this.bodyContent.writeOut(bodyContent.getEnclosingWriter());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_PAGE;
	}
	
	@Override
	public void doInitBody() throws JspException {
		System.out.println("doInitBody");
	}
	
	@Override
	public void setBodyContent(BodyContent b) {
		System.out.println("setBodyContent");
		this.bodyContent = b;
	}
}
