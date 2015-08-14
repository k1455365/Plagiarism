<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/Plagiarism_Detection/css/menu.css" />
<script type="text/javascript" src="/Plagiarism_Detection/js/menu.js"></script>
	<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
	</script>
</head>

<body>

<div id="my_menu" class="sdmenu" style="margin-top: 2px">
      <div>
        <span>Task</span>
        <a href="/Plagiarism_Detection/pages/task/TaskCreation.jsp" target="rightFrame">New</a>
        <a href="/Plagiarism_Detection/task/ShowTask.action" target="rightFrame">History</a>
      </div>
       <div>
        <span>System</span>
        <a href="/Plagiarism_Detection/pages/help/Introduction.html" target="rightFrame">User Manual</a>
        <a href="/Plagiarism_Detection/pages/help/Resources.html" target="rightFrame">Resource Download</a>
        <a href="/Plagiarism_Detection/pages/help/Contact.html" target="rightFrame">Contact Me</a>
        <a href="/Plagiarism_Detection/pages/help/About.html" target="rightFrame">About</a>
      </div>
</div>
</body>

</html>
