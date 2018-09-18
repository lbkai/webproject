<%@page import="com.business.entity.Providers"%>
<%@page import="com.business.util.Page"%>
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
    request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8"); 	
	
    ProviderService pvs = new ProviderService();	
	
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	
	Page<Providers> provpage = pvs.findtAllProvidersByPage(new Page<Providers>(currentPage,pageSize));
	request.setAttribute("provpage", provpage);
	 request.getRequestDispatcher("showAllProviders.jsp").forward(request, response);
%>	
<body>

</body>
</html>