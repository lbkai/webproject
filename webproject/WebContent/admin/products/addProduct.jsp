<%@page import="java.util.List"%>
<%@page import="com.business.entity.Products"%>
<%@page import="com.business.entity.Categorys"%>
<%@page import="com.business.entity.Providers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- <script type="text/javascript" src="../../javascript/My97DatePicker/WdatePicker.js"></script> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>
<%-- <%
	//接收数据
	Products p =(Products)request.getAttribute("p");
	List<Providers> listpv =(List<Providers>)request.getAttribute("pv");
	List<Categorys> listcg =(List<Categorys>)request.getAttribute("cg");
%> --%>
<body>
<form id = "myform" action="ProductsServlet?op=doAddProduct" method="post" >
	<table>
		<tr>
			<td>产品名</td><td><input id="product_name" type="text" name="product_name" onclick="checkName()" onchange="checkName()"  onblur="checkName()" /></td>
			<td><label id="nameresult" ></label></td>
		</tr>
		<tr>
			<td>产品进价</td><td><input id="income_price" type="text" name="income_price" onclick="checkInPri()" onchange="checkInPri()"  onblur="checkInPri()" /></td>
			<td><label id="inpriresult" ></label></td>
		</tr>
		<tr>
			<td>供应商</td>
			<td>
			<%-- <input type="text" name="provider" value="<%=p.getProviders().getProvider_name()%>" /> --%>
				<select name="provider">
				
					<%--  <%
						for(Providers prov : listpv){													
								
					%>
						<option value="<%=prov.getProviderID() %>"><%=prov.getProvider_name() %></option>
					<%			
														
						}
					%>  --%>
					<option value="0">请选择供应商</option>
					<c:forEach items="${pv}" var="prov">
						<option value="${prov.providerID}">${prov.provider_name}</option>
					</c:forEach>
					
				</select>
				
			</td>
		
		</tr>
		<tr>
			<td>产品数量</td><td><input id="quantity" type="text" name="quantity" onclick="checkQuantity()" onchange="checkQuantity()"  onblur="checkQuantity()" /></td>
			<td><label id="quantityresult" ></label></td>
		</tr>
		<tr>
			<td>产品售价</td><td><input id="sales_price" type="text" name="sales_price" onclick="checkSaPri()" onchange="checkSaPri"  onblur="checkSaPri()" /></td>
			<td><label id="sapriresult" ></label></td>
		</tr>
		<tr>
			<td>目录</td>
			<td>
			<%-- <input type="text" name="category" value="<%=p.getCategorys().getCategory_name() %>" /> --%>
			 <select name="categoey" >
				
					<%-- <%
						for(Categorys cat : listcg){
						%>	
						<option value="<%=cat.getCategoryID() %>"><%=cat.getCategory_name() %></option>
					<%
						}
					%> --%>
					<option value="0">请选择目录</option>
					<c:forEach items="${cg}" var="cate">
						<option value="${cate.categoryID}">${cate.category_name}</option>
					</c:forEach>
					
				</select> 
			</td>
		</tr>
		<tr>
			<td>进货时间</td>
			<td><input id="income_time" class="Wdate" name="income_time"  onclick="WdatePicker()" /></td>
			<td><label id="intimeresult" ></label></td>
		</tr>
		<tr>
			<td colspan="2">
			<!-- onclick="return submitForm()" submitForm()方法为真实提交表单，否则不提交 -->
			<input type="button" value="提交" onclick="checkAll()" />
			<input type="reset" value="重置数据" />
			</td>
		</tr>
		
	</table>

</form>
</body>
</html>

 <script type="text/javascript">
 var fn = false;
 var fip = false;
 var fq = false;
 var fsp = false;

 
 function checkName() {
     var val = document.getElementById("product_name").value;
     var regname = /^[\u4e00-\u9fa5]{2,4}$/;      
     if (val != "") {
       if (!regname.test(val)) {
         document.getElementById("nameresult").style.color = "red";
         document.getElementById("nameresult").innerHTML = "验证失败！";
       } else {
         document.getElementById("nameresult").style.color = "green";
         document.getElementById("nameresult").innerHTML = "验证成功！";
         fn = true;
       }
   }else{
		document.getElementById("nameresult").style.color = "red";
         document.getElementById("nameresult").innerHTML = "名称不能为空！";
	}
	}
 
 function checkInPri() {
     var val = document.getElementById("income_price").value;
     var regtel = /^([1-9]\d*|\d+\.\d+)$/;      
     if (val != "") {
       if (!regtel.test(val)) {
         document.getElementById("inpriresult").style.color = "red";
         document.getElementById("inpriresult").innerHTML = "验证失败！";
       } else {
         document.getElementById("inpriresult").style.color = "green";
         document.getElementById("inpriresult").innerHTML = "验证成功！";
         fip = true;
       }
   }else{
		document.getElementById("inpriresult").style.color = "red";
         document.getElementById("inpriresult").innerHTML = "电话不能为空！";
	}
	}
 function checkQuantity() {
     var val = document.getElementById("quantity").value;
     var regtel = /^\d+(\.{0,1}\d+){0,1}$/;      
     if (val != "") {
       if (!regtel.test(val)) {
         document.getElementById("quantityresult").style.color = "red";
         document.getElementById("quantityresult").innerHTML = "验证失败！";
       } else {
         document.getElementById("quantityresult").style.color = "green";
         document.getElementById("quantityresult").innerHTML = "验证成功！";
         fq = true;
       }
   }else{
		document.getElementById("quantityresult").style.color = "red";
         document.getElementById("quantityresult").innerHTML = "电话不能为空！";
	}
	}
 
 
 function checkSaPri() {
     var val = document.getElementById("sales_price").value;
     var regtel = /^([1-9]\d*|\d+\.\d+)$/;      
     if (val != "") {
       if (!regtel.test(val)) {
         document.getElementById("sapriresult").style.color = "red";
         document.getElementById("sapriresult").innerHTML = "验证失败！";
       } else {
         document.getElementById("sapriresult").style.color = "green";
         document.getElementById("sapriresult").innerHTML = "验证成功！";
         fsp = true;
       }
   }else{
		document.getElementById("sapriresult").style.color = "red";
         document.getElementById("sapriresult").innerHTML = "电话不能为空！";
	}
	}
 
 
/*  var fn = false;
 var fip = false;
 var fq = false;
 var fsp = false;
 var fit = false; */
 
 function checkAll(){
		//fn&&fip&&fq&&fsp
   if(fn&&fip&&fq&&fsp){
   	  document.getElementById("myform").submit();
   	   
   }else{
   	    checkName();
	   	checkInPri();
	   	checkQuantity();
	   	checkSaPri();
	   	checkInTime()
   	 
   }
	
}
 
 </script>