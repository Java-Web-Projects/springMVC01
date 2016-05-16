<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户[${customer.customerName }]详细信息</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>客户标识:</td><td>${customer.customerNO }</td>
	</tr>
	<tr>
	<td>客户名称:</td><td>${customer.customerName }</td>
	</tr>
	<tr>
	<td>电话号码:</td><td>${customer.phone }</td>
	</tr>
	<tr>
	<td>地址:</td><td>${customer.address }</td>
	</tr>
	<tr>
	<td>联系人:</td><td>${customer.relationman }</td>
	</tr>
	<tr>
	<td>其他信息:</td><td>${customer.otherInfo }</td>
	</tr>
</table>
</body>
</html>