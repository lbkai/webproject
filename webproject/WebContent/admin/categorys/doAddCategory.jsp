<%@page import="com.business.service.CategorysService"%>
<%@page import="com.business.entity.Categorys"%>
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
	String cstegory_name = request.getParameter("category_name");
	String cstegory_desc = request.getParameter("category_desc");
	
	Categorys c = new Categorys(cstegory_name,cstegory_desc);
	CategorysService cs = new CategorysService();
	int i = cs.addCategorysByName(c);
	if(i>0){
		out.write("<script>alert('恭喜，目录增加成功！');location.href ='doShowCategorys.jsp?currentPage=1&pageSize=3' </script>");
	}else{
		out.write("<script>alert('对不起，目录增加失败！');history.back() ;</script>");
	}
	
%>
<body>

</body>
</html>