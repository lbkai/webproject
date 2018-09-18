<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
//alert("self: "+self.location+" \n top:"+top.location);
		//登录页面总是显示在最上层
		if(self.location != top.location){
			top.location = "login.jsp";
		}
</script>
<body>
	<form action="LoginServlet" method="post" >
		<table align="center">
			<tr>
				<td>姓名：</td><td><input type = "text" name="userName" placeholder = "请输入用户名" /></td>
			</tr>
			<tr>
				<td>密码：</td><td><input type = "password" name="password" placeholder = "请输入密码" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type = "submit" value="登录" /><input type = "reset" value="重置数据" /></td>
			</tr>
		</table>
	</form>
</body>
</html>