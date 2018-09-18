<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="myform" action="doAddCategory.jsp" method="post">
	<table>
		<tr>
			<td>目录名称</td><td><input id="category_name" type="text" name="category_name" onclick="checkName()" onchange="checkName()"  onblur="checkName()" /></td>
			<td><label id="nameresult" ></label></td>
		</tr>
		<tr>
			<td>备注</td><td><input id="category_desc" type="text" name="category_desc" onclick="checkDesc()" onchange="checkDesc()"  onblur="checkDesc()" /></td>
			<td><label id="descresult" ></label></td>
		</tr>
		<tr>
			<td colspan="2">
			<!-- onclick="return submitForm()" submitForm()方法为真实提交表单，否则不提交 -->
			<input type="button" value="提交" onclick="checkAll1()" />
			<input type="reset" value="重置数据" />
			</td>
		</tr>
	</table>

</form>
</body>
</html>
 <script type="text/javascript">
 var fn = false;
 var fd = false;
 
 function checkName() {
     var val = document.getElementById("category_name").value;
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
 
 function checkDesc() {
     var val = document.getElementById("category_desc").value;
     var regtel = /^([\s\S]*)$/;      
     if (val != "") {
       if (!regtel.test(val)) {
         document.getElementById("descresult").style.color = "red";
         document.getElementById("descresult").innerHTML = "验证失败！";
       } else {
         document.getElementById("descresult").style.color = "green";
         document.getElementById("descresult").innerHTML = "验证成功！";
         fd = true;
       }
   }else{
		document.getElementById("descresult").style.color = "red";
         document.getElementById("descresult").innerHTML = "电话不能为空！";
	}
	}
 function checkAll1(){
		//fn&&fad&&ft&&fe
   if(fn&&fd){
   	  document.getElementById("myform").submit();
   	   
   }else{
   	    checkName();
         checkdesc();
   }
	
}
 
 </script>
