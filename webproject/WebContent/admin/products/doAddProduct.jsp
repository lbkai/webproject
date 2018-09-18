<%-- <%@page import="com.business.service.ProductsService"%>
<%@page import="com.business.entity.Providers"%>
<%@page import="com.business.entity.Categorys"%>
<%@page import="com.business.entity.Products"%>
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
	//得到add后的所有数据
	//int productID = Integer.parseInt(request.getParameter("productID"));
	String product_name = request.getParameter("product_name");
	double income_price = Double.parseDouble(request.getParameter("income_price"));
	int providerID = Integer.parseInt(request.getParameter("provider"));
	int quantity = Integer.parseInt(request.getParameter("quantity"));
	double sales_price = Double.parseDouble(request.getParameter("sales_price"));
	int categoeyID = Integer.parseInt(request.getParameter("categoey"));
	String income_time = request.getParameter("income_time");
	
	Products p = new Products(product_name, income_price, new Providers(providerID), 
			quantity, sales_price, new Categorys(categoeyID), income_time);
	ProductsService ps= new ProductsService();
	int i = ps.addProductsByName(p);
	if(i>0){
		out.write("<script>alert('恭喜，产品增加成功！');location.href ='ProductsServlet?op=doShowProducts&currentPage=1&pageSize=3' </script>");
	}else{
		out.write("<script>alert('对不起，产品增加失败！');history.back() ;</script>");
	}	
%>
<body>

</body>
</html>  --%>