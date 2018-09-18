<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	Cookie[] arr = request.getCookies();
	//String id = null;
	ArrayList<String> list = new ArrayList<String>();
	if(arr != null){
	for(Cookie c:arr){
		if(("goodsId_"+c.getValue()).equals(c.getName())){
			list.add(c.getValue());
		}
	}
	}
	pageContext.setAttribute("list", list);
%>
<body>
<table>
	<tr>
		<td>产品id</td><td>操作</td>
	</tr>
	<%-- <tr>
		<td><%=id %></td><td></td>
	</tr> --%>
	 <c:forEach items="${list }" var="g" >
		<tr>
			<td>${g}</td><td><a href="del.jsp?id=${g }">从购物车删除</a></td>
		</tr>
	</c:forEach> 
</table>
</body>
</html>