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
<form action="doDeleteProducts.jsp" method="post"> 
<table  width="95%" border="1px">
	<tr>
		<td>供应商ID</td><td>供应商名称</td><td>地址</td><td>联系方式</td><td>ACCOUNT</td><td>邮箱</td><td>操作</td>
	</tr>			
		<c:forEach items="${provpage.list}" var="pv">
			<tr>
				<td>${pv.providerID}</td>
				<td>${pv.provider_name}</td>
				<td>${pv.provider_add}</td>
				<td>${pv.provider_tel}</td>
				<td>${pv.account}</td>
				<td>${pv.email}</td>
		
				<td>
					<a href="#" onclick="del(${pv.providerID})">删除</a>
					&nbsp;&nbsp;&nbsp;
					<a href="#" onclick="modify(${pv.providerID})">修改</a>
				</td>
			</tr>		
		</c:forEach>
	
<tr>
	<td colspan="9" align="center">
			
		<c:if test="${provpage.currentPage==1 }">
			<a>上一页</a>
		</c:if>
		<c:if test="${provpage.currentPage>1 }">
			<a href="doShowProviders.jsp?currentPage=${provpage.upPage}&pageSize=3">上一页</a>
		</c:if>
		
		&nbsp;&nbsp;&nbsp;&nbsp;
		总共${provpage.totalPage}页
		&nbsp;&nbsp;
		第${provpage.currentPage}页
		&nbsp;&nbsp;&nbsp;&nbsp;			
		
		<c:if test="${provpage.currentPage==provpage.totalPage }">
			<a>下一页</a>
		</c:if>	
		<c:if test="${provpage.currentPage<provpage.totalPage }">
			<a href="doShowProviders.jsp?currentPage=${provpage.nextPage }&pageSize=3">下一页</a>
		</c:if>					
	</td>
	
</tr>
<tr>
	<td colspan="9" align="center">
		<a href="addProvider.jsp">增加</a>
	</td>
</tr>
	
</table>
</form> 
<script type="text/javascript" >
 	function del(id){
		//alert(id);							
	    location.href = "doDeleteProvider.jsp?id="+id;
		
		
	} 
	
	function modify(id){
		alert(id);
		 location.href = "doReadyEditProvider.jsp?id="+id;
	}
</script>
</body>
</html>