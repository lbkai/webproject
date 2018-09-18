<%-- <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.business.util.TimeHelper"%>
<%@page import="com.business.entity.Admin"%>
<%@page import="com.business.service.AdminService" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%
     /* 这里应该用java代码来得到从上一个页面传过来的数据 */
     /* 
     	四大作用域：
     	1：pageContext<值在当前页面>
		2：request<值保持在一次请求中>
		3：session<值保持在一次回话当中>
		4：application<值保持在服务器上，直到服务器重启或关闭>
     
     */
	//在jsp中可以直接使用的对象就是内置对象(九个)

	String name = request.getParameter("userName");
	String password = request.getParameter("password");			
	
	AdminService as = new AdminService();
	Admin admin = as.findAdminByLogin(new Admin(name,password));
	//System.out.println(name+" "+password);
	if(admin != null){
		//把登陆的用户设置到session里
		//pageContext.setAttribute("pageValue", "页面上的值");
		session.setAttribute("loginName", admin.getAdmin_name());
		//application.setAttribute("appValue", "服务器上的值");
		
		// 设置时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 
		// 获取当前时间
		String cutTime = sdf.format(new Date());
 
		/**
		 * 先把所有的cookie放入数组
		 */
 
		Cookie[] cookies = request.getCookies();
 
		String lastTime = null;
		/**
		 * 查询数组是否有lastTime的cookie
		 */
 
		if (cookies != null) {
			for (Cookie cookie : cookies) {
 
				// 如果有上次的登陆痕迹
				if (cookie.getName().equals("lastTime")) {
 					
					session.setAttribute("loginTime", cookie.getValue());
					// 把时间显示在浏览器
					lastTime = cookie.getValue();
					//response.getWriter().write("欢迎回来! 您上次登录是在:" + lastTime);
					// 更新cookie
					cookie.setValue(cutTime);
					// 设置过期时间一个月
					cookie.setMaxAge(1 * 30 * 24 * 60 * 60);
					// 把更新的数据发送到浏览器储存起来
					response.addCookie(cookie);
					break;
				}
 
			}
		}
 
		if (cookies == null || lastTime == null) {
 
			// 没有cookie 创建对象
			// 显示当前时间
 			session.setAttribute("loginTime", cutTime);
			//response.getWriter().write("你好,欢迎登录 这是您的第一次" + cutTime);
			// 把数据存储到cookie中
			Cookie cookie = new Cookie("lastTime", cutTime);
			// 设置过期时间
			cookie.setMaxAge(1 * 30 * 60 * 24 * 60);
			// 存储到服务器
			response.addCookie(cookie);
		}


		//生成一个Cookie("loginTime" String)
		//Cookie cookie = new Cookie("loginTime",TimeHelper.getTime(t));
		
		out.write("<script>alert('恭喜，登录成功！');location.href='main.jsp'</script>");
	}else{
		out.write("<script>alert('对不起，用户名或密码错误！');location.href='login.jsp'</script>");
	}
	
%>

<body>
	<%=admin %>
	
</body>
</html> --%>