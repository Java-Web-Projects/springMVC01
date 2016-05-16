<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品更新</title>
</head>
<body>
<sf:form method="post" modelAttribute="product">
<table width="700" align="center" border="1">
	<tr>
	<td>产品名称:</td><td>${product.proname }<sf:hidden path="proname"/></td>
	</tr>
	<tr>
	<td>产品照片:</td><td><sf:input path="image"/>
	</tr>
	<tr>
	<td>产品价格:</td><td><sf:input path="price"/></td>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="产品更新"/>
	</td>
	</tr>
</table>
</sf:form>
</body>
</html>