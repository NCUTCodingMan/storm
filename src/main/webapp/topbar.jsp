<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<!-- 简单导航栏模板 -->
	<%-- ${pageContext.request.contextPath} 访问的根目录(站点的根路径),即/Rainbow --%>
	<div class="navbar navbar-inverse navbar-fixed-top" style="line-height:30px">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="#">Rainbow System</a>
				<div class="nav-collapse collapse" style="padding:5px;font-size:18px">
					<ul class="nav navbar-nav">
						<li class="dropdown active">
							<a class="dropdown-toggle" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								商品管理
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="${pageContext.request.contextPath}/good/viewGood.action">
										查看商品
									</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/good/createGood.jsp">
										新增商品
									</a>
								</li>
								<li class="divider"></li>
								<li><a href="#">商品分类</a></li>
								<li><a href="#">商品统计</a></li>
							</ul>
						</li>
						<li><a href="#">库存管理</a></li>
						<li><a href="#">订单管理</a></li>
						<li><a href="#">查询统计</a></li>
					</ul>
				</div>
				<button class="btn btn-primary pull-right" style="font-size:18px;margin:0">
					退出
				</button>
			</div>
		</div>
	</div>