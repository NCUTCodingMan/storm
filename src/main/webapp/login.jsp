<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rainbow login</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/docs.css" rel="stylesheet">
<style type="text/css">
	body{
		background-color:#f5f5f5;
	}
	.menu{
		margin:180px auto;
		align:center;
		width:500px;
	}
	.lead{
		font-size:25px;
	}
	input{
		width:180px;
	}
</style>
</head>
<body>
   	<div class="menu">
		<p  class="lead">Rainbow后台管理系统</p>
		<form class="form-horizontal" action="login.action" method="post">
			<label class="control-label" for="inputEmail">Username</label>
			<div class="control-group">
	 			<div class="controls">
	 				<input type="text" id="inputEmail" placeholder="Username" name="username">
	 			</div>
	 		</div>
			<label class="control-label" for="password">Password</label>
			<div class="control-group">
	 			<div class="controls">
	 				<input type="password" id="password" placeholder="Password" name="password">
	 			</div>
	 		</div>
			<div class="controls">
	 			<button type="submit" class="btn btn-success">Sign in</button>
	 			&nbsp;&nbsp;&nbsp;
	 			<button type="reset" class="btn">Back up</button>
	 		</div>
    	</form>
    	<hr/>
	   	<s:fielderror cssStyle="font-size:15px;color:#505050"></s:fielderror>
    </div>
</body>
</html>