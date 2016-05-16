<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>订单编号: ${pagers.total }</td><td>产品名称</td><td>客户名称</td><td>产品数量</td><td>下单时间</td><td>其他信息</td>
	<td>操作</td>
	</tr>
	<c:if test="${pagers.total le 0 }">
		<tr>
		<td colspan="6">当前没有订单信息</td>
		</tr>
	</c:if>
	<c:if test="${pagers.total gt 0}">
		<c:forEach items="${pagers.datas }" var="ord">
		<tr>
		<td><a href="${ord.orderNO }">${ord.orderNO }</a></td>
		<td>${ord.product.proname }</td>
		<td>${ord.customer.customerName }</td>
		<td>${ord.quantity }</td><td>${ord.orderTime }</td><td>${ord.otherInfo }</td>
		<td><a href="${ord.orderNO }/update">更新</a>&nbsp;<a href="${ord.orderNO }/delete">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="6">
			<jsp:include page="/inc/pager.jsp">
				<jsp:param value="orders" name="url"/>
				<jsp:param value="${pagers.total}" name="items"/>
			</jsp:include>
		</td>
		</tr>	
	</c:if>
</table>
</body>
</html>