<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Demo</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body style="background-color:#f5f5f5">
	<div style="margin:200px auto;align:center;width:500px;">
	<p style="font-size:25px" class="lead">Rainbow后台管理系统</p>
	<form class="form-horizontal">
		<label class="control-label" for="inputEmail">Username</label>
		<div class="control-group">
 			<div class="controls">
 				<input type="text" id="inputEmail" placeholder="Username" style="width:180px">
 			</div>
 		</div>
		<label class="control-label" for="password">Password</label>
		<div class="control-group">
 			<div class="controls">
 				<input type="password" id="password" placeholder="Password" style="width:180px">
 			</div>
 		</div>
		<div class="controls">
 			<button type="submit" class="btn btn-success">Sign in</button>
 			&nbsp;&nbsp;&nbsp;
 			<button type="reset" class="btn">Back up</button>
 		</div>
    </form>
    </div>
</body>
</html>