<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String  id = request.getParameter("id");
	//生成一个cookie对象（默认情况下，cookie的生存时间就是关闭了浏览器就没了）
	Cookie cookie = new Cookie("goodsId_"+id,id);//键值对
	//1-1：单位秒
	cookie.setMaxAge(60*60*24);
	
	//2 把cookie写到客户端
	response.addCookie(cookie);
%>
<body>
<a href="showCart.jsp">显示购物车</a>
</body>
</html>