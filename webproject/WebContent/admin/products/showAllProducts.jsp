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

<%-- <%	
	//List<Products> list = (List<Products>)request.getAttribute("list");
	Page<Products> propage = (Page<Products>)request.getAttribute("propage");	
	List<Products> list = propage.getList();
%> --%>

<body>
<form action="doDeleteProducts.jsp" method="post"> 
<table  width="95%" border="1px">
	<tr>
		<td>产品ID</td><td>产品名称</td><td>产品进价</td><td>供应商</td><td>数量</td><td>产品售价</td><td>产品目录</td><td>进货时间</td><td>操作</td>
	</tr>
	
<%-- <% 
	for(Products pro:list){
	 %>
	 <tr>
	  	<td><%=pro.getProductID() %></td>
	 	<td><%=pro.getProduct_name() %></td>
	 	<td><%=pro.getIncome_price() %></td>
	 	<td><%=pro.getProviders().getProviderID() %></td>
	 	<td><%=pro.getQuantity() %></td>
	 	<td><%=pro.getSales_price() %></td>
	 	<td><%=pro.getCategorys().getCategoryID() %></td>
	 	<td><%=pro.getIncome_time() %></td>

	 	
	 	<td>
	 	<!-- 	<input type = "button" value="删除"  />
	 		<input type = "button" value="修改" /> -->
	 		<a href="#" onclick="del(<%=pro.getProductID() %>)">删除</a>
	 		<a href="#" onclick="modify(<%=pro.getProductID() %>)">修改</a>
	 	</td>
	 	
	 </tr>	
	 <%
	}
%> --%>
		
		<c:forEach items="${propage.list}" var="p">
			<tr>
				<td>${p.productID}</td>
				<td>${p.product_name}</td>
				<td>${p.income_price}</td>
				<td>${p.providers.provider_name}</td>
				<td>${p.quantity}</td>
				<td>${p.sales_price}</td>
				<td>${p.categorys.category_name}</td>
				<td>${p.income_time}</td>
				<td>
					<a href="#" onclick="del(${p.productID})">删除</a>
					&nbsp;&nbsp;&nbsp;
					<a href="#" onclick="modify(${p.productID})">修改</a>
				</td>
			</tr>		
		</c:forEach>
	
<tr>
	<td colspan="9" align="center">
	
	<%-- <%
		if(propage.getCurrentPage()==1){
			%>
			<a>上一页</a>
			<%
		}else{
			%>
			<a href="doShowProducts.jsp?currentPage=<%=propage.getUpPage() %>&pageSize=3">上一页</a>
			<%
		}
	%> --%>
		
		<c:if test="${propage.currentPage==1 }">
			<a>上一页</a>
		</c:if>
		<c:if test="${propage.currentPage>1 }">
			<a href="ProductsServlet?op=doShowProducts&currentPage=${propage.upPage}&pageSize=3">上一页</a>
		</c:if>
		
		&nbsp;&nbsp;&nbsp;&nbsp;
		<%-- <a>总共<%=propage.getTotalPage() %>页</a> --%>
		总共${propage.totalPage}页
		&nbsp;&nbsp;
		<%-- <a>第<%=propage.getCurrentPage() %>页</a> --%>
		第${propage.currentPage}页
		&nbsp;&nbsp;&nbsp;&nbsp;
		
		<%-- <%
			if(propage.getCurrentPage()==propage.getTotalPage()){
				%>
				 <a>下一页</a>
				<%
			}else{
				%>
					<a href="doShowProducts.jsp?currentPage=<%=propage.getNextPage() %>&pageSize=3">下一页</a>
				<%
			}
		%>	 --%>	
		
		<c:if test="${propage.currentPage==propage.totalPage }">
			<a>下一页</a>
		</c:if>	
		<c:if test="${propage.currentPage<propage.totalPage }">
			<a href="ProductsServlet?op=doShowProducts&currentPage=${propage.nextPage }&pageSize=3">下一页</a>
		</c:if>					
	</td>
	
</tr>
<tr>
	<td colspan="9" align="center">
		<a href="ProductsServlet?op=doReadyProducts">增加</a>
	</td>
</tr>
	
</table>
</form> 
<script type="text/javascript" >
 	function del(id){
		//alert(id);							
	    location.href = "ProductsServlet?op=doDeleteProducts&id="+id;
		
		
	} 
	
	function modify(id){
		//alert(id);
		 location.href = "ProductsServlet?op=doReadyEdit&id="+id;
	}
</script>
</body>

</html>