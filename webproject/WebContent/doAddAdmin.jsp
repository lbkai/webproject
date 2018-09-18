<%@page import="com.business.entity.Admin"%>
<%@page import="com.business.service.AdminService"%>
<%@page import="com.sun.tools.javac.util.Name"%>
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
	String admin_id = request.getParameter("admin_id");
	int adminid = Integer.parseInt(admin_id);
  	String name = request.getParameter("userName");
	String password = request.getParameter("password");
	AdminService as = new AdminService();
	boolean admin = as.addAdmin(new Admin(adminid,name,password));
	
	
%>
</body>
</html>