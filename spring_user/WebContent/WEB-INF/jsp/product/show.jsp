<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品-[${product.proname }]详细信息</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>产品编号:</td><td>${product.productNO }</td>
	</tr>
	<tr>
	<td>产品名称:</td><td>${product.proname }</td>
	</tr>
	<tr>
	<td>产品照片:</td><td>${product.image }</td>
	</tr>
	<tr>
	<td>产品价格:</td><td>${product.price }</td>
	</tr>
</table>
</body>
</html>