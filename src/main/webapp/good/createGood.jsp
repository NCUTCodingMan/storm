<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建商品</title>
	<link href="../css/bootstrap.css" rel="stylesheet">
	<link href="../css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../ico/favicon.png" rel="shortcut icon">
    <style type="text/css">
    	body {
        	background-color:#f5f5f5;
      	}
		.menu {
		  max-width: 500px;
		  padding: 100px;
		  margin: 0 auto;
		}
    </style>
</head>
<body>
	<jsp:include page="../topbar.jsp"></jsp:include>
	<div style="align:center" class="menu">
	<form class="form-horizontal" action="createGood.action" method="post">
			<h2 class="muted" style="font-size:25px">添加商品</h2>
	   		<div class="control-group">
	   			<label class="control-label" for="inputEmail">商品编号:</label>
	   			<div class="controls">
	   				<input type="text" name="goodCode" id="inputEmail" placeholder="GoodCode">
	   			</div>
	   		</div>
	   		<div class="control-group">
	   			<label class="control-label" for="inputPassword">商品名称:</label>
	   			<div class="controls">
	   				<input type="text" name="goodName" id="inputPassword" placeholder="GoodName">
	   			</div>
	   		</div>
	   		<div class="control-group">
	   			<label class="control-label" for="inputPassword">商品价格:</label>
	   			<div class="controls">
	   				<input type="text" name="goodPrice" id="inputPassword" placeholder="GoodPrice">
	   			</div>
	   		</div>
	   		<div class="control-group">
	   			<label class="control-label" for="inputPassword">商品类型:</label>
	   			<div class="controls">
	   				<input type="text" name="goodType" id="inputPassword" placeholder="GoodType">
	   			</div>
	   		</div>
	   		<div class="control-group">
	   			<div class="controls">   				
	   				<button type="submit" class="btn">提交</button>
	   				&nbsp;&nbsp;				
	   				<button type="reset" class="btn">返回</button>
	   			</div> 			
	   		</div>
	   	</form>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>