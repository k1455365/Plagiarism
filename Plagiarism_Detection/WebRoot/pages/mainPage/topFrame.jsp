<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="/Plagiarism_Detection/css/frame.css" />
<title>frame-top</title>
</head>

<body>
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
						<td style="color:#FFFFFF;" width="28.9%">Welcome User： 2: <s:text
								name="username"></s:text> 3: <s:property value="username" /> 4:
							${username} ${password} 5: <s:property value="#session.username" />
						</td>
						<td width="70%" align="right">
							<table id="DataList1" cellspacing="0" cellpadding="0"
								style="border-width:0px;height:26px;border-collapse:collapse;">
								<tr>
									<td align="center" style="white-space:nowrap;"><a
										href="">&nbsp;Logout</a>
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
</body>
</html>