<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户更新</title>
</head>
<body>
<sf:form method="post" modelAttribute="customer">
<table width="700" align="center" border="1">
	<tr>
	<td>客户名称:</td><td>${customer.customerName }<sf:hidden path="customerName"/></td>
	</tr>
	<tr>
	<td>电话号码:</td><td><sf:input path="phone"/><sf:errors path="phone"/></td>
	</tr>
	<tr>
	<td>地址:</td><td><sf:input path="address"/></td>
	</tr>
	<tr>
	<td>联系人:</td><td><sf:input path="relationman"/><sf:errors path="relationman"/></td>
	</tr>
	
	<tr>
	<td>其他信息:</td><td><sf:input path="otherInfo"/></td>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="客户更新"/>
	</td>
	</tr>
</table>
</sf:form>
</body>
</html>