<%@page import="com.business.service.ProductsService"%>
<%@page import="com.business.util.Page"%>
<%@page import="com.business.entity.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>



<body>
<form action="doDeleteCategorys.jsp" method="post"> 
<table  width="95%" border="1px">
	<tr>
		<td>目录ID</td><td>目录名称</td><td>备注</td><td>操作</td>
	</tr>			
		<c:forEach items="${propage.list}" var="p">
			<tr>
				<td>${p.categoryID}</td>
				<td>${p.category_name}</td>
				<td>${p.category_desc}</td>
		
				<td>
					<a href="#" onclick="del(${p.categoryID})">删除</a>
					&nbsp;&nbsp;&nbsp;
					<a href="#" onclick="modify(${p.categoryID})">修改</a>
				</td>
			</tr>		
		</c:forEach>
	
<tr>
	<td colspan="9" align="center">
			
		<c:if test="${propage.currentPage==1 }">
			<a>上一页</a>
		</c:if>
		<c:if test="${propage.currentPage>1 }">
			<a href="doShowCategorys.jsp?currentPage=${propage.upPage}&pageSize=3">上一页</a>
		</c:if>
		
		&nbsp;&nbsp;&nbsp;&nbsp;
		总共${propage.totalPage}页
		&nbsp;&nbsp;
		第${propage.currentPage}页
		&nbsp;&nbsp;&nbsp;&nbsp;			
		
		<c:if test="${propage.currentPage==propage.totalPage }">
			<a>下一页</a>
		</c:if>	
		<c:if test="${propage.currentPage<propage.totalPage }">
			<a href="doShowCategorys.jsp?currentPage=${propage.nextPage }&pageSize=3">下一页</a>
		</c:if>					
	</td>
	
</tr>
<tr>
	<td colspan="9" align="center">
		<a href="addCategory.jsp">增加</a>
	</td>
</tr>
	
</table>
</form> 
<script type="text/javascript" >
 	function del(id){
		//alert(id);							
	    location.href = "doDeleteCategory.jsp?id="+id;
		
		
	} 
	
	function modify(id){
		alert(id);
		 location.href = "doReadyEdit.jsp?id="+id;
	}
</script>
</body>

</html>