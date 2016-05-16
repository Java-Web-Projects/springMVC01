<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报价[${quotation.quotationNO }]详细信息</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>报价编号:</td><td>${quotation.quotationNO }</td>
	</tr>
	<tr>
	<td>产品名称:</td><td>${quotation.product.proname }</td>
	</tr>
	<tr>
	<td>客户名称:</td><td>${quotation.customer.customerName }</td>
	</tr>
	<tr>
	<td>报价人:</td><td>${quotation.quotationMan }</td>
	</tr>
	<tr>
	<td>报价时间:</td><td>${quotation.quotationTime }</td>
	</tr>
	<tr>
	<td>其他信息:</td><td>${quotation.otherInfo }</td>
	</tr>
</table>
</body>
</html>