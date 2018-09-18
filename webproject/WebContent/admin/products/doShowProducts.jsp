<%-- <%-- <%@page import="com.sun.tools.javac.util.Name"%>
<%@page import="com.business.util.Page"%>
<%@page import="com.business.entity.Products"%>
<%@page import="java.util.List"%>
<%@page import="com.business.service.ProductsService"%>
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
	/* request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8"); */
	
	
    ProductsService ps = new ProductsService();
	//List<Products> list = ps.findAllProducts();
	//request.setAttribute("list", list);
	
	/* String scurrentPage = (String)request.getAttribute("currentPage");
	int currentPage = Integer.parseInt(scurrentPage);
	String spageSize = (String)request.getAttribute("pageSize");
	int pageSize = Integer.parseInt(spageSize); */
	
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	
	Page<Products> propage = ps.findAllProductByPage(new Page<Products>(currentPage,pageSize));
	request.setAttribute("propage", propage);
	 request.getRequestDispatcher("showAllProducts.jsp").forward(request, response);
%>	

<%=list.size() %> 
</body>
</html> --%> --%>