<%@page import="com.business.entity.Categorys"%>
<%@page import="com.business.service.CategorysService"%>
<%@page import="com.sun.tools.javac.util.Name"%>
<%@page import="com.business.util.Page"%>
<%@page import="com.business.entity.Products"%>
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
    request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8"); 	
	
    CategorysService cs = new CategorysService();	
	
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	
	Page<Categorys> propage = cs.findtAllCategorysByPage(new Page<Categorys>(currentPage,pageSize));
	request.setAttribute("propage", propage);
	 request.getRequestDispatcher("showAllCategorys.jsp").forward(request, response);
%>	

</body>
</html>