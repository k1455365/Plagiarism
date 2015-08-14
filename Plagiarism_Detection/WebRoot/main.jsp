<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>同源性比对系统</title>
</head>
<frameset rows="86,*,11" frameborder="no" border="0" framespacing="0">
	<frame src="pages/mainPage/topFrame.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frame src="pages/mainPage/centerFrame.html" name="mainFrame" id="mainFrame" />
	<frame src="pages/mainPage/downFrame.html" name="downFrame" scrolling="no" noresize="noresize" id="downFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
