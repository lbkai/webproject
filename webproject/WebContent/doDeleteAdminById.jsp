<%@page import="java.io.PrintWriter"%>
<%@page import="com.business.view.Process"%>
<%@page import="com.business.entity.Admin"%>
<%@page import="com.business.service.AdminService"%>
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
   
	String admin_id = request.getParameter("admin_id");	
    int adminid = Integer.parseInt(admin_id);
    AdminService as = new AdminService();
	//Admin adminid = new Admin(admin_id);
	
	boolean f = as.removeAdmin(new Admin(adminid));	
	if(f){
		out.write("<script>alert('删除成功！')</script>");
	}else{
		out.write("<script>alert('删除失败！');location.href = 'DeleteAdminById.jsp'</script>");
	}
	
%>

</body>
</html>