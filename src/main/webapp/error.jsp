<%@page import="com.rain.taglib.Employee"%>
<%@page import="com.rain.taglib.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入自定义的标签库 -->
<%@ taglib prefix="g" uri="/TagWithBodylib"%>
<%@ taglib prefix="i" uri="/Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
</head>
<body>
	请您登录系统
	<g:loop count="5">
		现在的时间是 : <%=new java.util.Date() %> <br/>
	</g:loop>
	<%
		Company company = new Company();
		company.setName("Orc");
		
		Employee e1 = new Employee();
		e1.setName("scott");
		e1.setPhone("123456789");
		e1.setEmail("110@qq.com");
		e1.setComment("fresh man");
		
		Employee e2 = new Employee();
		e2.setName("rain");
		e2.setPhone("11111111");
		e2.setEmail("000@qq.com");
		e2.setComment("senior man");
		
		company.addEmployee(e1);
		company.addEmployee(e2);
		
		request.setAttribute("company", company);
	%>
	<%-- 
		这个报错的原因是未识别到employee所指向的Employee对象
		<jsp:useBean id="employee" class="com.rain.taglib.Employee"></jsp:useBean>
		<jsp:getProperty property="name" name="employee"/>
	--%>
	<table>
		<tr>
			<td>姓名</td>
			<td>联系电话</td>
			<td>邮箱</td>
			<td>备注</td>
		</tr>
		<i:iterator name="employee" type="Employee" iterator="<%=company.getEmployees()%>">
			<!-- 使用el来取出pageContext中存放的Employee对象 -->
			<tr>
				<td>${employee.name}</td>
				<td>${employee.email}</td>
				<td>${employee.phone}</td> 
				<td>${employee.comment}</td>
			</tr>
		</i:iterator>
	</table>
</body>
</html>