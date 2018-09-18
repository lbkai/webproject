<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>用户管理</p>
<p><a href="admin/products/ProductsServlet?op=doShowProducts&currentPage=1&pageSize=3" target="right" >产品管理</a></p>
<p><a href="admin/categorys/CategorysServlet?currentPage=1&pageSize=3" target="right">种类管理</a></p>
<p><a href="admin/providers/ProvidersServlet.jsp?currentPage=1&pageSize=3" target="right">供应商管理</a></p>
</body>
</html>