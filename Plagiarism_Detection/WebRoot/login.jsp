<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="/Plagiarism_Detection/ccs/styles.css">
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
	background-image: url(/Plagiarism_Detection/image/login_background.jpg);
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.STYLE3 {
	font-size: 20px;
	color: #ffffff;
	font-weight: bold;
}

.buttonstyle {
	cursor: pointer;
	width: 60px;
	height: 30px;
	font-size: 14px;
}

.inputstyle {
	width: 200px;
	height: 24px;
	background-color: #93D3EE;
	border: solid 1px #153966;
	font-size: 16px;
	color: #283439;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

#div1 {
	left: 35%;
	top: 50%;
	position: absolute;
	width: 100%;
	min-width: 700px;
	width: expression_r(document.body.clientWidth <     700 ?     "700px" :    
		"auto");
}

table {
	table-layout: automatic;
}
</style>
<script type="text/javascript">
	function decoration() {
		var div1 = document.getElementById("div1");

		var leftvalue = (window.innerWidth - 360) / 2 / window.innerWidth;
		div1.setAttribute("left", leftvalue);
	}
</script>
</head>

<body onload="decoration();">
	<div id="div1">
		<s:form method="post" action="loginaction">
			<table border="0" cellpadding="0" cellspacing="0"
				style="width:360px;table-layout:automatic;min-width:360px;">
				<tbody>
					<!--  	<tr height="350px"></tr> -->
					<tr>
						<!--  <td width="500px"></td>-->
						<td height="100px" width="280px">
							<table border="0" cellpadding="0" cellspacing="0" width="100%"
								align=style="table-layout:automatic;">
								<tbody>
									<tr>
										<!-- <td height="30px" valign="bottom" width="70px"><div
											align="right">
											<span class="STYLE3">User Name</span>
										</div>
									</td> -->
										<td valign="bottom" width="10px">&nbsp;</td>
										<td colspan="2" height="30px" valign="bottom">
											<div align="left">
												<s:textfield label="User Name" id="username" name="username" />
											</div>
										</td>
									</tr>
									<tr>
										<!-- <td height="30px" valign="bottom"><div align="right">
											<span class="STYLE3">Password:</span>
										</div>
									</td> -->
										<td valign="bottom" width="10px">&nbsp;</td>
										<td colspan="2" height="30px" valign="bottom"><s:password
												name="password" label="Password" />
										</td>
									</tr>
									<tr>
										<td colspan="4"><div align="center" id="tips"
												style="width:210px; height:16px; background-color:transparent; border:solid 0px #153966; font-size:12px; color:#ff0000"></div>
										</td>
									</tr>
									<tr>
										<td valign="bottom" width="30px">&nbsp;</td>
										<td valign="bottom" width="10px">&nbsp;</td>
										<td height="30px" valign="bottom" width="30px"><s:submit></s:submit>
										</td>
									</tr>
								</tbody>
							</table> </s:form>
							</div>
</body>
</html>
