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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="/Plagiarism_Detection/js/jscharts_mb.js"></script>
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
	tasklist page for user:
	<s:property value="username" />
	<table class="table" style="width:98%; min-width:300px;" align="center"
		cellspacing="1">
		<thead>
			<tr>
				<th>
					<!-- <input type="checkbox" name="select_all" id="select_all"
					onclick="select_allcbx()" /> --></th>
				<th>ID</th>
				<th>taskname</th>
				<th>result</th>
				<th>srcdir</th>
				<th>trgdir</th>
				<th>tasktime</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="tasklist">
				<tr>
					<td class="left"><s:property value="id" /></td>
					<td><s:property value="taskname" /></td>
					<td><s:property value="result" /></td>
					<td><s:property value="srcdir" /></td>
					<%-- 	<td><s:if test="${taskway==1}">text</s:if>
						<s:else>java</s:else>
					</td> --%>
					<td><s:property value="trgdir" /></td>
					<td><s:date name="tasktime" /></td>
				</tr>
			</s:iterator>
		</tbody>
		<tfoot>
	</table>
</body>
</html>
