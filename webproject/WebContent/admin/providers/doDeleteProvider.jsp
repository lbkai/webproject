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
	int id = Integer.parseInt(request.getParameter("id"));
	
	ProviderService pvs = new ProviderService();
	int i = pvs.removeProvidersByPvid(id);
	
	if(i>0){
		out.write("<script>alert('恭喜，供应商删除成功！');location.href ='doShowProviders.jsp?currentPage=1&pageSize=3' </script>");
	}else{
		out.write("<script>alert('对不起，目录被产品引用故删除失败！');history.back() ;</script>");
	}


%>
<body>

</body>
</html>