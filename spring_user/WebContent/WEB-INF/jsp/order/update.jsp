<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单更新</title>
</head>
<body>
<sf:form method="post" modelAttribute="order">
<table width="700" align="center" border="1">
	<tr>
	<td>数量:</td><td><sf:input path="quantity"/></td>
	</tr>
	
	<tr>
	<td>产品名称:</td>
	
	<td>
	<sf:select name="productNO" path="product" >
		<sf:option value="0" label="---Select---"/> 
		<sf:options items="${productss.datas }" itemValue="productNO" itemLabel="proname"/>
	</sf:select>
	</td>
	
	</tr>
	<tr>
	<td>客户名称:</td>

	<td>
<sf:select name="customerNO" path="customer" >
		<sf:option value="0" label="---Select---"/> 
		<sf:options items="${customerss.datas }" itemValue="customerNO" itemLabel="customerName"/>
	</sf:select>
	</td>

	</tr>
	
	<tr>
	<td>下单时间:</td><td><sf:input path="orderTime"/></td>
	</tr>
	
	<tr>
	<td>其他信息:</td><td><sf:input path="otherInfo"/></td>
	</tr>
	
	<tr>
	<td colspan="2">
		<input type="submit" value="Order Update"/>
	</td>
	</tr>
</table>
</sf:form>
</body>
</html>