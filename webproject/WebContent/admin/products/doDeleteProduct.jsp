<%-- <%@page import="com.business.entity.Products"%>
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
   /*  String products_ID = request.getParameter("productsID");	
	int productsID = Integer.parseInt(products_ID);  */
	
    int id = Integer.valueOf(request.getParameter("id"));
	ProductsService ps = new ProductsService();
	/* Products p = new Products();
	ps.removeProducts(new Products(p.getProductID())); */
	boolean f = ps.removeProductsById(id);
	
	if(f){
		out.write("<script>alert('恭喜，产品删除成功！');location.href ='doShowProducts.jsp?currentPage=1&pageSize=3' </script>");
	}else{
		out.write("<script>alert('对不起，产品删除失败！');location.href ='doShowProducts.jsp?currentPage=1&pageSize=3' </script>");
	}
	
%>
</body>
</html> --%>