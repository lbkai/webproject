<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="myform" action="doAddProvider.jsp" method="post" >
	<table>
		<tr>
			<td>供应商名称</td><td><input id="provider_name" style="text" name="provider_name" onclick="checkName()" onchange="checkName()"  onblur="checkName()" /></td>
			<td><label id="nameresult" ></label></td>
		</tr>	
		<tr>
			<td>地址</td><td><input id="provider_add" style="text" name="provider_add" onclick="checkAdd()" onchange="checkAdd()" onblur="checkAdd()" /></td>
			<td><label id="addresult" ></label></td>
		</tr>
		<tr>
			<td>联系方式</td><td><input id="provider_tel" style="text" name="provider_tel" onclick="checkTel()" onchange="checkTel()" onblur="checkTel()" /></td>
			<td><label id="telresult" ></label></td>
		</tr>
		<tr>
			<td>ACCOUNT</td><td><input id="account" style="text" name="account"  /></td>
			<td><label id="accresult" ></label></td>
		</tr>		
		<tr>	
			<td>邮箱</td><td><input id="email" style="text" name="email" onclick="checkEmail()" onchange="checkEmail()" onblur="checkEmail()" /></td>	
			<td><label id="emailresult" ></label></td>
		</tr>
		<tr>
			<td colspan="2">
			<!-- onclick="return submitForm()" submitForm()方法为真实提交表单，否则不提交 -->
			<input  type="button" value="提交" onclick="checkAll1()" />
			
			<input type="reset" value="重置数据" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>

<script type="text/javascript">

	var fn = false;
	var fad= false;
	var ft= false;
	var fe= false;

	function checkName() {
		    var val = document.getElementById("provider_name").value;
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
	  
	   function checkAdd() {
		    var val = document.getElementById("provider_add").value;
		    var regadd = /^([^\x00-\xff]|[A-Za-z0-9_])+$/;      
		    if (val != "") {
		      if (!regadd.test(val)) {
		        document.getElementById("addresult").style.color = "red";
		        document.getElementById("addresult").innerHTML = "验证失败！";
		      } else {
		        document.getElementById("addresult").style.color = "green";
		        document.getElementById("addresult").innerHTML = "验证成功！";
		        fad = true;
		      }
		  	}else{
				document.getElementById("addresult").style.color = "red";
		        document.getElementById("addresult").innerHTML = "住址不能为空！";
		       
			}
		}
	  
	   function checkTel() {
		    var val = document.getElementById("provider_tel").value;
		    var regtel = /^1(3|4|5|7|8)\d{9}$/;      
		    if (val != "") {
		      if (!regtel.test(val)) {
		        document.getElementById("telresult").style.color = "red";
		        document.getElementById("telresult").innerHTML = "验证失败！";
		      } else {
		        document.getElementById("telresult").style.color = "green";
		        document.getElementById("telresult").innerHTML = "验证成功！";
		        ft = true;
		      }
		  	}else{
				document.getElementById("telresult").style.color = "red";
		        document.getElementById("telresult").innerHTML = "电话不能为空！";
		       
		  	}
		}
	   
	/*      function checkAccount() {
		    var val = document.getElementById("provider_tel").value;
		    var regtel = /^[\u4e00-\u9fa5]$/;      
		    if (val != "") {
		      if (!regtel.test(val)) {
		        document.getElementById("telresult").style.color = "red";
		        document.getElementById("telresult").innerHTML = "验证失败！";
		      } else {
		        document.getElementById("telresult").style.color = "green";
		        document.getElementById("telresult").innerHTML = "验证成功！";
		        return true;
		      }
		 	 }else{
				document.getElementById("telresult").style.color = "red";
		        document.getElementById("telresult").innerHTML = "电话不能为空！";
			}
		} */
	   
	   
	     function checkEmail() {
		    var val = document.getElementById("email").value;
		    var regemail = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;      
		    if (val != "") {
		      if (!regemail.test(val)) {
		        document.getElementById("emailresult").style.color = "red";
		        document.getElementById("emailresult").innerHTML = "验证失败！";
		      } else {
		        document.getElementById("emailresult").style.color = "green";
		        document.getElementById("emailresult").innerHTML = "验证成功！";
		        fe = true;
		      }
		  	}else{
				document.getElementById("emailresult").style.color = "red";
		        document.getElementById("emailresult").innerHTML = "邮箱不能为空！";
		      
		  	}
		}
	     
	     
	     function checkAll1(){
				//fn&&fad&&ft&&fe
		      if(fn&&fad&&ft&&fe){
		      	  document.getElementById("myform").submit();
		      	   
		      }else{
		      	    checkName();
		            checkAdd();
		     	    checkTel();
		            checkEmail(); 
		          //  alert("dddd");
		      }
	     	
	     }
  
</script>
