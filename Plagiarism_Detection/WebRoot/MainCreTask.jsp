<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="/Plagiarism_Detection/css/frame.css" />
<link rel="stylesheet" type="text/css"
	href="/Plagiarism_Detection/css/style.css" />
<style type="text/css">
.style1 {
	width: 200px;
}

.style3 {
	width: 210px;
}

.type-file-box {
	position: relative;
	width: 260px
}

input {
	vertical-align: middle;
	margin: 0;
	padding: 0
}

.type-file-text {
	height: 22px;
	border: 1px solid #cdcdcd;
	width: 180px;
}

.type-file-button {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 24px;
	width: 70px;
}

.type-file-file {
	position: absolute;
	top: 0;
	right: 0;
	height: 24px;
	filter: alpha(opacity :   0);
	opacity: 0;
	width: 260px
}
/* div{
	display:none;
	height: 100%;
	background-color: #F0F4FA;
	overflow: hidden;
	overflow-y: scroll;
	overflow-x: scroll;} */
</style>
</head>

<body>
	<s:form method="post" action="creTaskAction">
		<%--     this is the main page welcome 
    2: <s:text name="username"></s:text>
    3: <s:property value="username"/>
    4: ${username}      ${password}
    5: <s:property value="#session.username" /> --%>

		<table>
			<!--     topFrmae -->
			<tr>
				<table style="width:100%; min-width:400px;" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td height="57"
							background="/Plagiarism_Detection/image/topBackground.png"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="240" height="57"
										background="/Plagiarism_Detection/image/kcl_logo.png">&nbsp;</td>
									<td>&nbsp;</td>
									<td width="281" valign="bottom"></td>
								</tr>
							</table></td>
					</tr>
					<tr>
						<td height="30" background="/Plagiarism_Detection/image/bar.png">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="0.6%" height="20"></td>
									<td style="color:#FFFFFF;" width="28.9%">Welcome User： <s:property
											value="username" /></td>
									<td width="70%" align="right">
										<table id="DataList1" cellspacing="0" cellpadding="0"
											style="border-width:0px;height:26px;border-collapse:collapse;">
											<tr>
												<td align="center" style="white-space:nowrap;"><a
													href="/Plagiarism_Detection/login/logoutaction.action">&nbsp;Logout</a>
												</td>
											</tr>
										</table>
									</td>
									<td width="0.5%"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</tr>
			<!--    centerFrame -->
			<tr>
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="8" bgcolor="#ed403c">&nbsp;</td>
						<td width="8" bgcolor="#ed403c">&nbsp;</td>
						<td valign="top" height="100%" width="100%" border="0"
							frameborder="0">


							<div class="clear" style="height:20px;"></div>
							<h2 style="width:90%; min-width:200px;">
								<img src="/Plagiarism_Detection/image/tb.gif" align="middle" /><span>Add
									a new plagiarism detection task</span>
							</h2>
							<table>
								<!--     basic information -->
								>
								<table class="table form" style="width:90%; min-width:300px;"
									align="center" cellspacing="1">
									<tr class="odd">
										<td class="column1">Task Name:</td>
										<td><input type="text" class="text" name="taskname"
											id="taskname" size="40" /></td>
									</tr>
									<tr>
										<td class="column1">File Type:</td>
										<td><select tabindex="普通" name="taskway"><option
													value="1">text</option>
												<option value="2">java</option>
										</select>
										</td>
									</tr>
								</table>
								<!--     upload files -->
								<table class="table form" style="width:90%; min-width:300px;"
									align="center" cellspacing="1">
									<!-- 									<tr class="odd">
										<td class="column1">Choose 1st file:</td>
										<td><input name="fstFile" type="file" id="doc" /></td>
									</tr>
									<tr>
									<td class="column1">Choose 2nd file:</td>
									<td><input name="secFile" type="file" id="doc" /></td>
									</tr> -->
									<tr class="odd">
										<td class="column1">Choose 1st file:</td>
										<td><input name="srcdir" type="file" id="doc" />
										</td>
									</tr>
									<tr>
										<td class="column1">Choose 2nd file:</td>
										<td><input name="trgdir" type="file" id="doc" />
										</td>
									</tr>
									<tr class="odd">
										<td colspan="2">
											<div align="center">
												<input type="button" class="button" value="Previous Page"
													onclick="javascript:history.go(-1)" />&nbsp;&nbsp;&nbsp;
												<!-- <input id="formsubmit" type="button" class="button" value="Start Analyse"/>  -->
												<s:submit></s:submit>
											</div>
										</td>
									</tr>
								</table>
							</table>
						</td>
						<td width="8" bgcolor="#ed403c">&nbsp;</td>
						<td width="8" bgcolor="#ed403c">&nbsp;</td>
					</tr>
				</table>
			</tr>
			<!--     downframe -->
			<tr>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					margin-left="0px" margin-top="0px" margin-right="0px"
					margin-bottom="0px">
					<tr>
						<td background="/Plagiarism_Detection/image/bar.png"
							style="line-height:11px; table-layout:fixed" width="166">&nbsp;</td>
						<td background="/Plagiarism_Detection/image/bar.png"
							style="line-height:11px; table-layout:fixed">&nbsp;</td>
						<td background="/Plagiarism_Detection/image/bar.png"
							style="line-height:11px; table-layout:fixed" width="17">&nbsp;</td>
					</tr>
				</table>
			</tr>
		</table>
		<div style="display:none">
			<s:textfield name="username">
				<s:property value="username" />
			</s:textfield>
		</div>
	</s:form>
</body>
</html>