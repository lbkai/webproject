<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String loginName = (String)session.getAttribute("loginName");
		if(loginName == null){
			out.write("<script>alert('对不起，请先登录');location.href='login.jsp'</script>");
		}
%>