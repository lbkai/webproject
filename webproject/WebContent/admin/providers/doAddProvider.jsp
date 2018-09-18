<%@page import="com.business.service.ProviderService"%>
<%@page import="com.business.entity.Providers"%>
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
	//获取录入后的数据
	String provider_name = request.getParameter("provider_name");
	String provider_add = request.getParameter("provider_add");
	String provider_tel = request.getParameter("provider_tel");
	String account = request.getParameter("account");
	String email = request.getParameter("email");
	
	Providers pv = new Providers(provider_name,provider_add,provider_tel,account,email);
	ProviderService pvs = new ProviderService();
	int i = pvs.addProvidersByName(pv);
	
	if(i>0){
		out.write("<script>alert('恭喜，供应商增加成功！');location.href ='doShowProviders.jsp?currentPage=1&pageSize=3' </script>");
	}else{
		out.write("<script>alert('对不起，目录增加失败！');history.back() ;</script>");
	}
	
%>
<body>

</body>
</html>