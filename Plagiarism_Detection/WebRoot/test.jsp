<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  </head>
  
  <body>
<%--     this is the main page welcome 
    2: <s:text name="username"></s:text>
    3: <s:property value="username"/>
    4: ${username}      ${password}
    5: <s:property value="#session.username" /> --%>
    <table>
<!--     topFrmae -->
    <tr>
    <table style="width:100%; min-width:400px;" border="0" cellspacing="0"
		cellpadding="0">
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
						<td style="color:#FFFFFF;" width="28.9%">Welcome User： <s:property value="username" />
						</td>
						<td width="70%" align="right">
							<table id="DataList1" cellspacing="0" cellpadding="0"
								style="border-width:0px;height:26px;border-collapse:collapse;">
								<tr>
									<td align="center" style="white-space:nowrap;"><a
										href="/webcmp/login/Quit.action">&nbsp;Logout</a>
									</td>
								</tr>
							</table>
						</td>
						<td width="0.5%"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table></tr>
<!--    centerFrame -->
<tr>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="8" bgcolor="#ed403c">&nbsp;</td>
    <td width="150" valign="top">
		<iframe height="100%" width="100%" border="0" frameborder="0" src="leftFrame.jsp" name="leftFrame" id="leftFrame" title="leftFrame"></iframe>
	</td>
    <td width="8" bgcolor="#ed403c">&nbsp;</td>
    <td valign="top">
		<iframe height="100%" width="100%"  border="0" frameborder="0" src="blankRight.html" name="rightFrame" id="rightFrame" title="rightFrame"></iframe>
	</td>
    <td width="8" bgcolor="#ed403c">&nbsp;</td>
  </tr>
</table>
</tr>
<!--     downframe -->
    <tr>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" 	margin-left="0px" margin-top="0px" margin-right="0px"margin-bottom="0px">
  <tr>
    <td background="/Plagiarism_Detection/image/bar.png"  style="line-height:11px; table-layout:fixed" width="166">&nbsp;</td>
    <td background="/Plagiarism_Detection/image/bar.png"  style="line-height:11px; table-layout:fixed">&nbsp;</td>
    <td background="/Plagiarism_Detection/image/bar.png"  style="line-height:11px; table-layout:fixed" width="17">&nbsp;</td>
  </tr>
</table>
    </tr>
    </table>
  </body>
</html>