<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="doUpdateAdmin.jsp" method="post" >
		<table align="center">
		<tr>
				<td>id：</td><td><input type = "text" name="admin_id" placeholder = "请输入密码" /></td>
			</tr>
			<!-- <tr>
				<td>姓名：</td><td><input type = "text" name="userName" placeholder = "请输入用户名" /></td>
			</tr>
			<tr>
				<td>密码：</td><td><input type = "password" name="password" placeholder = "请输入密码" /></td>
			</tr> -->
			<tr>
				<td colspan="2"><input type = "button" value="查找" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type = "submit" value="修改" /><input type = "reset" value="重置数据" /></td>
			</tr>
		</table>
	</form>
</body>
</html>