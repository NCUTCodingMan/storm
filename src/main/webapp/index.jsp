<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
    <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="ico/favicon.png" rel="shortcut icon">
    <title>Rainbow后台管理系统</title>
    <style type="text/css">
      body {
        padding-top: 60px;
        background-color:#f5f5f5;
      }
    </style>
  </head>
  <body>
  	<!-- 
  		动态引入topbar.jsp,并且分开编译两个index.jsp与topbar.jsp
  		把行成的html再加到一起,所以不会出现重复定义的问题.
  	-->
	<jsp:include page="topbar.jsp"></jsp:include>
    <div class="container"></div>
    <!-- 引入jquery,bootstrap -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
  </body>
</html>
