<%@page import="com.business.service.CategorysService"%>
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
	int id =Integer.parseInt(request.getParameter("id"));
	CategorysService cs = new CategorysService();
	int i = cs.removeCategorysByCid(id);
	if(i>0){
		out.write("<script>alert('恭喜，目录删除成功！');location.href ='doShowCategorys.jsp?currentPage=1&pageSize=3' </script>");
	}else{
		out.write("<script>alert('对不起，目录被产品引用无法删除 ！');location.href ='doShowCategorys.jsp?currentPage=1&pageSize=3' </script>");
	}
%>
</body>
</html>