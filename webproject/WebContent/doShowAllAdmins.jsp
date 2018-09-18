<%@page import="java.util.List"%>
<%@page import="com.business.entity.Admin"%>
<%@page import="com.business.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	AdminService as = new AdminService();
	List<Admin> list = as.findAllAdmin();
	//把数据设到request里
	request.setAttribute("adminList", list);
	//服务器内部跳转；保持原来的请求和响应不变；地址不变
	  request.getRequestDispatcher("showAllAdmins.jsp").forward(request, response);
	//重定向：生成新的请求
	//response.sendRedirect("showAllAdmins.jsp");
	
	
%>
</body>
</html>