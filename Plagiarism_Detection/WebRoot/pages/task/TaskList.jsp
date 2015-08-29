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
<link rel="stylesheet" type="text/css" href="/Plagiarism_Detection/css/style.css" />
<script type="text/javascript"
	src="/Plagiarism_Detection/js/jscharts_mb.js"></script>
<script type="text/javascript" src="/Plagiarism_Detection/js/layout.js"></script>
<script type="text/javascript">
function configTrg() {
	var trgFile = document.getElementById('trgFile').innerHTML;
	var srcFile = document.getElementById('srcFile').innerHTML;
	/* alert(srcFile); */
	srcFile = filename(srcFile);
	trgFile = filename(trgFile);
	/* alert(srcFile); */
	document.getElementById('src').innerHTML=srcFile;
	document.getElementById('trg').innerHTML=trgFile;}
</script>
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

<body onload="configTrg()">
	tasklist page for user:
	<s:property value="username" />
	<table  class="table" style="width:98%; min-width:300px;" align="center" cellspacing="1">
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
					<td class="left"><s:property value="id"/></td>
					<td><s:property value="taskname" /></td>
					<td><s:property value="algorithm" /></td>
					<td><s:property value="taskway" /></td>
					<td><s:property value="threshold" /></td>
					<td><s:property value="hits" /></td>
					<td><s:property value="indel" /></td>
					<td><s:property value="replacement" /></td>
					<td><s:property value="srcdir" /></td>
					<td><s:property value="trgdir" /></td>
					<!-- <td id="src"></td>
					<td id="trg"></td> -->
					<td><s:date name="tasktime" /></td>
					<td><s:property value="result" /></td>
					<td><a
						href="/Plagiarism_Detection/ShowTaskResultDetails.action?taskid=${id}">details</a>
					</td>

				</tr>
			</s:iterator>
		</tbody>
		<tfoot>
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
