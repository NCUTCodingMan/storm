<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 若未引入jstl.jar,standard.jar此处会报错 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品展示</title>
	<!-- 页面需要导入的css文件 -->
	<link href="../css/bootstrap.css" rel="stylesheet">
	<link href="../css/bootstrap-responsive.css" rel="stylesheet">
	<link href="../css/bootstrap-table.css">
    <link href="../ico/favicon.png" rel="shortcut icon">
    <style type="text/css">
      body {
        background-color:#f5f5f5;
      }
    </style>
</head>
<body>
	<!-- 模板导航jsp文件 -->
	<jsp:include page="../topbar.jsp"></jsp:include>
	<div style="min-height:500px;width:1200px;margin:100px auto">
		<div class="panel panel-default" style="min-height:300px;">
			<h3 class="muted">商品列表</h3>
			<div class="panel-body" style="min-height:298px;">
				<table class="table table-striped" style="font-size:14px;">
					<tr>						
						<th>商品编号</th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>商品类型</th>
						<th></th>
						<th></th>	
					</tr>
					<!-- 使用jstl提供的标签库遍历List -->
					<c:forEach var="good" items="${page.list}" begin="0" end="9" step="1">
						<tr>							
							<td>${good.goodCode}</td>
							<td>${good.goodName}</td>
							<td>${good.goodPrice}</td>
							<td>${good.goodType}</td>
							<td>
								<a href="${pageContext.request.contextPath}/good/editGood.jsp?id=${good.goodId}">
									edit
								</a>
							</td>
							<td width="116px">
								<a href="${pageContext.request.contextPath}/good/deleteGood.action?id=${good.goodId}">
									delete
								</a>
							</td>							
						</tr>
					</c:forEach>
					<!-- 使用struts2封装的ongl表达式遍历goods -->
					<!--
					<s:iterator value="goods" id="g">
						<tr>							
							<td><s:property value="#g.getGoodCode()"/></td>
							<td><s:property value="#g.getGoodName()"/></td>
							<td><s:property value="#g.getGoodPrice()"/></td>
							<td><s:property value="#g.getGoodType()"/></td>
							<td>
								<a href="good/editGood.action?id=
									<s:property value="#g.getGoodId()"/>">
									edit
								</a>
							</td>
							<td width="116px">
								<a href="good/editGood.action?id=
									<s:property value="#g.getGoodId()"/>">
									delete
								</a>
							</td>							
						</tr>
					</s:iterator>
					-->
				</table>
			</div>
			<!--
		    <div class="pagination pull-right">
			    <ul>
				    <li><a href="#">Prev</a></li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li><a href="#">Next</a></li>
			    </ul>
			</div>
			-->
			<!-- 分页页面 -->
			<jsp:include page="../page.jsp"></jsp:include>
		</div>
	</div>
	<!-- 页面导入库js文件 -->
	<script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>