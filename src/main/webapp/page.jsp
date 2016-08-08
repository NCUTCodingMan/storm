<!-- 导入JSTL标准库 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="pull-right">
	<c:if test="${page.pageNumber > 1}">
		[<a href="${page.url}?pageNumber=${page.pageNumber - 1}">上一页</a>]
	</c:if>
	当前第${page.pageNumber}页
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		[<a href="${page.url}?pageNumber=${i}">${i}</a>]
	</c:forEach>
	<c:if test="${page.endPage < page.totalPage}">
		[<a href="${page.url}?pageNumber=${page.pageNumber + 1}">下一页</a>]
	</c:if>
	共${page.totalPage}页,共${page.totalRecord}记录
</div>