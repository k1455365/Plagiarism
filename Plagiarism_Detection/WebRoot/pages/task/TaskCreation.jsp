<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TaskCreation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/Plagiarism_Detection/css/style.css" />
<style type="text/css">
        .style1
        {
            width: 200px;
        }
        .style3
        {
            width: 210px;
        }
	.type-file-box{ position:relative;width:260px}
	input{ vertical-align:middle; margin:0; padding:0}
	.type-file-text{ height:22px; border:1px solid #cdcdcd; width:180px;}
	.type-file-button{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:70px;}
	.type-file-file{ position:absolute; top:0; right:0; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
  </head>
  
  <body>
  <s:form method="post" action="creTaskAction">
  <div class="clear" style="height:20px;"></div>
<h2 style="width:90%; min-width:200px;" ><img src="/Plagiarism_Detection/image/tb.gif" align="middle" /><span>Add a new plagiarism detection task</span></h2>
    <table>
<!--     basic information -->>
<table class="table form" style="width:90%; min-width:300px;" align="center" cellspacing="1">
  <tr class="odd">
    <td class="column1">Task Name:</td>
    <td><input type="text" class="text" name="taskname" id="taskname" size="40"/></td>
  </tr>
  <tr>
    <td class="column1">File Type:</td>
    <td>
        <select tabindex="普通" name="taskway"><option value="1">text</option><option value="2">java</option></select>
      </td>
  </tr></table>
<!--     upload files -->
<table class="table form" style="width:90%; min-width:300px;" align="center" cellspacing="1">
      <tr> <tr class="odd">
    <td class="column1">Choose 1st file:</td>
    <td >
   	<input name="srcdir" type="file" id="doc" />
     </td> 
  </tr>
   
    <td class="column1">Choose 2nd file:</td>
    <td >
   	<input name="trgdir" type="file" id="doc" />
     </td>  
  </tr>
  <tr> <tr class="odd">
   <td colspan="2">
    	<div align="center">
    		<input type="button" class="button" value="Previous Page" onclick="javascript:history.go(-1)"/>&nbsp;&nbsp;&nbsp;
    		<!-- <input id="formsubmit" type="button" class="button" value="Start Analyse"/>  -->
    		<s:submit></s:submit>
    	</div>
    </td>
  </tr></table>
  </table>
  </s:form>
  </body>
</html>
