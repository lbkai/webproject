<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%


/*
session的生命周期：出生：（jsp）第一次访问页面，request.getSession();
				销毁：自动过期，服务重启，关闭；session.invalidate();
*/

	//存在cookie中的JSESSIONID
	Cookie[] arr = request.getCookies();
	String CID = null;
	for(Cookie c:arr){
		if("JSESSIONID".equals(c.getName())){
			CID = c.getValue();
			//持久化session就是持久化存session的cookie
			c.setMaxAge(60*10);
			//写回到客户端
			response.addCookie(c);
		}
	}
	
	String SID = session.getId();
%>
<body>
<%
	String loginName = (String)session.getAttribute("loginName");
    String loginTime = (String)session.getAttribute("loginTime");

%>
<h3>CID:<%=CID %></h3>
<h3>SID:<%=SID %></h3>
<h3>欢迎<%=loginName %>进入系统,你上次登陆的时间为<%=loginTime %></h3>
</body>
</html>