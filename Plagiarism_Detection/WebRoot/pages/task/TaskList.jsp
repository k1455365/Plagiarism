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

<title>My JSP 'TaskList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="/Plagiarism_Detection/css/style.css" />
<script type="text/javascript"
	src="/Plagiarism_Detection/js/jscharts_mb.js"></script>
<script type="text/javascript" src="/Plagiarism_Detection/js/layout.js"></script>
<style type="text/css">
a.white {
	color: #ffffff;
}

.white {
	color: #ffffff;
}

#ipt_gotopage {
	width: 15px;
}
</style>
</head>

<body>
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
							</table>
						</td>
					</tr>
					<tr>
						<td height="30" background="/Plagiarism_Detection/image/bar.png">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="0.6%" height="20"></td>
									<td style="color:#FFFFFF;" width="28.9%">Welcome User： <s:property
											value="username" />
									</td>
									<td width="0.6%" height="20"></td>
									<td width="70%" align="right">
										<table id="DataList1" cellspacing="0" cellpadding="0"
											style="border-width:0px;height:26px;border-collapse:collapse;">
											<tr>
												<td align="center" style="white-space:nowrap;"><a
													href="/Plagiarism_Detection/login/logoutaction.action">&nbsp;Logout &nbsp;</a>
												</td>
											</tr>
										</table></td>
									<td width="0.5%"></td>
								</tr>
							</table></td>
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
							<table class="table" style="width:98%; min-width:300px;" align="center"
		cellspacing="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>task name</th>
				<th>algorithm</th>
				<th>task type</th>
				<th>threshold</th>
				<th>score of hits</th>
				<th>score of indel</th>
				<th>score of replacement</th>
				<th>srcdir</th>
				<th>trgdir</th>
				<th>tasktime</th>
				<th>result</th>
				<th>operations</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="tasklist">
				<tr>
					<td class="left"><s:property value="id" />
					</td>
					<td><s:property value="taskname" />
					</td>
					<td><s:property value="algorithm" />
					</td>
					<td><s:property value="taskway" />
					</td>
					<td><s:property value="threshold" />
					</td>
					<td><s:property value="hits" />
					</td>
					<td><s:property value="indel" />
					</td>
					<td><s:property value="replacement" />
					</td>
					<td><s:property
							value="srcdir.split('\\\\/')[srcdir.split('\\\\/').length-1]" />
					</td>
					<td><s:property
							value="trgdir.split('\\\\/')[trgdir.split('\\\\/').length-1]" />
					</td>
					<!-- <td id="src"></td>
					<td id="trg"></td> -->
					<td><s:date name="tasktime" />
					</td>
					<td><s:property value="score" />
					</td>
					<td><a
						href="/Plagiarism_Detection/ShowTaskResultDetails.action?taskid=${id}">details</a>
					</td>

				</tr>
			</s:iterator>
		</tbody>
		<tfoot>
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
<div id="srcFile" style="display:none">
		<s:property value="srcfile" />
	</div>
	<!-- trgFileName -->
	<div id="trgFile" style="display:none">
		<s:property value="trgfile" />
	</div>
</body>
</html>
