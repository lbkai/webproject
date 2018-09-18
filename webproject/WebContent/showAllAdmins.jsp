<%@page import="com.business.entity.Admin"%>
<%@page import="java.util.List"%>
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
	//从request里得到数据
	List<Admin> list = (List<Admin>)request.getAttribute("adminList");
	
	for(Admin a:list){
%>

	<%=a %><br />	
	
<%		
	}
%>
</body>
</html>