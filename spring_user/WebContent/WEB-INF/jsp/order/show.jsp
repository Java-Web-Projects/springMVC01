<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单[${order.orderNO }]详细信息</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>订单编号:</td><td>${order.orderNO }</td>
	</tr>
	<tr>
	<td>产品名称:</td><td>${order.product.proname }</td>
	</tr>
	<tr>
	<td>客户名称:</td><td>${order.customer.customerName }</td>
	</tr>
	<tr>
	<td>数量:</td><td>${order.quantity }</td>
	</tr>
	<tr>
	<td>下单时间:</td><td>${order.orderTime }</td>
	</tr>
</table>
</body>
</html>