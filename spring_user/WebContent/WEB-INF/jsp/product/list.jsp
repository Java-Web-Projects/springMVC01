<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品列表</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>产品标识:${pagers.total }</td><td>产品名称</td><td>产品照片</td><td>产品价格</td>
	<td>操作</td>
	</tr>
	<c:if test="${pagers.total le 0 }">
		<tr>
		<td colspan="6">Currently No Product Datas</td>
		</tr>
	</c:if>
	<c:if test="${pagers.total gt 0}">
		<c:forEach items="${pagers.datas }" var="pro">
		<tr>
		<td>${pro.productNO }</td>
		<td><a href="${pro.productNO }">${pro.proname }</a></td>
		<td>${pro.image }</td><td>${pro.price }</td>
		<td><a href="${pro.productNO }/update">更新</a>&nbsp;<a href="${pro.productNO }/delete">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="6">
			<jsp:include page="/inc/pager.jsp">
				<jsp:param value="products" name="url"/>
				<jsp:param value="${pagers.total}" name="items"/>
			</jsp:include>
		</td>
		</tr>	
	</c:if>
</table>
</body>
</html>