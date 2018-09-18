<%@page import="java.util.List"%>
<%@page import="com.business.entity.Categorys"%>
<%@page import="com.business.service.CategorysService"%>
<%@page import="com.business.entity.Providers"%>
<%@page import="com.business.service.ProviderService"%>
<%@page import="com.sun.net.ssl.internal.ssl.Provider"%>
<%@page import="com.business.entity.Products"%>
<%@page import="com.business.service.ProductsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	
	//得到所有供应商数据
	ProviderService pvs = new ProviderService();
	List<Providers> pv =  pvs.findAllProviders();
	//得到所有目录数据
	CategorysService cgs = new CategorysService();
	List<Categorys> cg = cgs.findAllCategorys();
	
	//传值
	
	request.setAttribute("pv", pv);
	request.setAttribute("cg",cg);
	
	request.getRequestDispatcher("addProducts.jsp").forward(request, response);
	
%>
<body>

</body>
</html>