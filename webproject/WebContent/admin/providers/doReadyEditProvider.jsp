<%@page import="com.business.entity.Providers"%>
<%@page import="com.business.service.ProviderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	int id = Integer.valueOf(request.getParameter("id"));
	//获取要修改的所有数据
	ProviderService cs = new ProviderService();
	Providers pv = cs.findProviderById(id);
	//传值
	request.setAttribute("pv", pv);
	request.getRequestDispatcher("editProvider.jsp").forward(request, response);
%>
<body>

</body>
</html>