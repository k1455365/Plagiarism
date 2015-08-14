<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Register Page</title>
<script type="text/javascript" src="/Plagiarism_Detection/js/layer.js"></script>

<style>
.form td {
	text-align: left;
	padding: 2px 8px;
	border: 0px;
}

.form td.column1 {
	text-align: right;
	vertical-align: top;
	width: 300px;
}

.t tr.odd td {
	background: #d3eaef;
}

h2 {
	background-image: url(/webcmp/images/5.png);
	padding: 3px 0px 5px 0px;
	width: 600p;
	margin: 3px auto 3px auto; x;
	font-weight: 100;
	font-style: normal;
	font-size: 14px;
}

.t {
	border: 1px solid #a8c7ce;
	border-collapse: collapse;
	color: #344b50;
	line-height: 30px;
	background: #fff;
}

body {
	font-family: Tahoma, Verdana, Arial, sans-serif;
	font-size: 14px;
	color: #000;
	margin: 3px;
}

.input_submit {
	cursor: pointer;
	width: 50px;
	font-size: 14px;
	border: 1px solid #72a1bd;
	padding: 2px 8px 0px 8px;
	color: #369;
	background: url(/webcmp/images/bg.gif) repeat-x;
}

input {
	width: 400px;
}

.text {
	height: 25px;
}

.tips {
	font-size: 12px;
	color: rgba(0, 0, 0, 0.5);
	margin-right: 5px;
}
</style>

<script type="text/javascript">

function CheckPassword()
{
	hide('password_t');

	if(document.getElementById('password').value == null ||document.getElementById('password').value == ""){
    	return ;
    }
	
	var password=document.getElementById("password").value;
	if(password=="")
	{
		$("#accept1").hide();
		$("#reg1").show();
	}
	else
	{
		$("#accept1").show();
		$("#reg1").hide();
	}
}

function CheckRePassword()
{
	hide('rePassword_t');
	
	if(document.getElementById('rePassword').value == null ||document.getElementById('rePassword').value == ""){
    	return ;
    }
	
	var password=document.getElementById("password").value;
	var rePassword=document.getElementById("rePassword").value;
	if(rePassword=="")
	{
		$("#accept2").hide();
		$("#reg2").show();
	}
	else
	{
		if(password!=rePassword)
		{
			$("#accept2").hide();
			$("#reg2").show();
		}
		else
		{
			$("#accept2").show();
			$("#reg2").hide();
		}
	}
}

function validate_form(thisform){
	var isIdUsed = false;
	with (thisform)
	{
		if (validate_required(username,"用户名没有填写!")==false){
			username.focus();
			return false;
		}
		$.post("/webcmp/login/regist!regist.action", { memberid:$("#username").val()},
		function (data, textStatus){
			if(data.isMemberIdUsed==true)
			{
				isIdUsed = true;
				alert("用户名被注册，请选用其它用户名!")
			}
		}, "json");
		
		if(isIdUsed == true){
			isIdUsed = false;
			username.focus();
			return false;
		}
		
		if(validate_required(password,"密码没有填写!")==false){
			password.focus();
			return false;
		}
		if(validate_required(rePassword,"密码确认没有填写!")==false){
			rePassword.focus();
			return false;
		}
		if(validate_required(email,"邮箱没有填写!")==false){
			email.focus();
			return false;
		}
		if(passwordCheck() == false){
			return false;
		}
		if(isEmail(email.value) == false){
			alert("邮箱格式不正确!");
			return false;
		}
			return true;
	}
};

function passwordCheck()
{
	if(document.getElementsByName('password')[0].value != document.getElementsByName('rePassword')[0].value)
	{
		alert("两次输入的密码不相同！")
		return false;
	}
	return true;
}

function validate_required(field,alerttxt){
	with (field){
		if (value==null||value==""){
			alert(alerttxt);
			return false;
		}
		else {
			return true;
		}
	}
};

//显示提示信息的函数
function display(s){
	document.getElementById(s).style.display = "inline";
	switch (s){
		case 'username_t':
			$("#accept").hide();
			$("#reg").hide();
			break;
		case 'password_t':
			$("#accept1").hide();
			$("#reg1").hide();
			break;
		case 'rePassword_t':
			$("#accept2").hide();
			$("#reg2").hide();
			break;
		case 'email_t':
			$("#accept3").hide();
			$("#reg3").hide();
			break;
	}		
}

//隐藏提示信息
function hide(s){
	var sh = "#" + s;
	$(sh).hide();
}

function cancel(){
	history.go(-1);
}

$(document).ready(function(){
	$("img").hide();
});
</script>
</head>

<body>
	<s:form method="post" action="registeraction">
		<h2 style="width:98%; min-width:800px;">
			<img src="/webcmp/images/tb.gif" align="absmiddle"
				sytle="margin-left:8px" /> <span
				style="margin-left:10px;color:#ffffff;">Become a new user</span>
		</h2>

		<div style="width:100%; min-width:800px;" align="center">
			<table class="t form" style="width:98%; min-width:800px;"
				cellspacing="1">
				<tr class="odd">
					<td class="column1">User Name</td>
					<td><s:textfield type="text" class="text" name="username"
						id="username" size="40" onfocus="display('username_t')"
						onblur="CheckUsername()" /> <span id="username_t" class="tips"
						style="display: none;">Can't be empty</span></td>
				</tr>
				<tr>
					<td class="column1">Password</td>
					<td><s:password type="password" class="text" name="password"
						id="password" size="40" onfocus="display('password_t')"
						onblur="CheckPassword()" /> &nbsp;&nbsp; <img
						src="/webcmp/images/accept.png" alter="可用" name="accept"
						id="accept1" hidden=true> <img
						src="/webcmp/images/cancel.png" alter="不可用" name="reg" id="reg1"
						hidden=true> <span id="password_t" class="tips"
						style="display: none;">不可以为空，密码请用数字、字母和下划线组成</span></td>
				</tr>
				<tr class="odd">
					<td class="column1">Confirm Password</td>
					<td><input type="password" class="text" name="rePassword"
						id="rePassword" size="40" onfocus="display('rePassword_t')"
						onblur="CheckRePassword()" /> &nbsp;&nbsp; <img
						src="/webcmp/images/accept.png" alter="可用" name="accept"
						id="accept2" hidden=true> <img
						src="/webcmp/images/cancel.png" alter="不可用" name="reg" id="reg2"
						hidden=true> <span id="rePassword_t" class="tips"
						style="display: none;">不可以为空，两次输入的密码必须相同</span></td>
				</tr>
	
				<tr>
					<td colspan="2">
						<div align="center">
							<s:submit type="button" class="input_submit" value="Regist"
								></s:submit>&nbsp;&nbsp;&nbsp; <input
								type="button" class="input_submit" value="Cancel" onclick="cancel()" />
						</div></td>
				</tr>
			</table>
		</div>
	</s:form>
</body>
</html>

