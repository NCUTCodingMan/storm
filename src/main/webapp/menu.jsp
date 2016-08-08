<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下拉菜单</title>
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="ico/favicon.png" rel="shortcut icon">
</head>
<body>
	<!-- 扁平,易响应的导航栏 -->
	
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="dropdown active">
				<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					Java
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">SimpleDateFormat</a></li>
					<li><a href="#">Locale</a></li>
					<li><a href="#">ResourceBundle</a></li>
				</ul>
			</li>
		</ul>
	</div>
	
	
	<!-- 简单导航栏模板 -->
	<!-- 
	<div class="navbar navbar-fixed-top navbar-inverse" style="line-height:30px">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="#">Rainbow</a>
				<div class="nav-collapse collapse" style="padding:5px;font-size:18px">
					<ul class="nav navbar-nav">
						<li class="dropdown active">
							<a class="dropdown-toggle" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								Java
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">Collection</a></li>
								<li><a href="#">Map</a></li>
							</ul>
						</li>
						<li><a href="#">C</a></li>
						<li><a href="#">C++</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	-->
	<!-- 引入jquery,bootstrap -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!--  
    <script type="text/javascript">
    	$('.dropdown-toggle').dropdown();
    </script>
    -->
</body>
</html>