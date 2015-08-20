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
<title>My JSP 'tokenResult.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<table width="100%" border="1" cellspacing="1" cellpadding="5">
  <tr>
    <td colspan="2">Character Result </td>
    <td width="49%">score:<s:property value="textsim" /></td>
  </tr>
  <tr>
    <td width="10%" rowspan="2">original</td>
    <td width="41%"><s:property value="srcfile" /></td>
    <td><s:property value="srccontent" /></td>
  </tr>
  <tr>
    <td><s:property value="trgfile" /></td>
    <td><s:property value="trgcontent" /></td>
  </tr>
  <tr>
    <td width="10%" rowspan="2">similar part</td>
    <td width="41%"><s:property value="srcfile" /></td>
    <td><s:property value="AlignmentA" /></td>
  </tr>
  <tr>
    <td><s:property value="trgfile" /></td>
    <td><s:property value="AlignmentB" /></td>
  </tr>
  <tr>
    <td height="30" colspan="2" align="left">score matrix</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td><s:property value="matrix"/></td>
  </tr>
</table>
</body>

</html>
