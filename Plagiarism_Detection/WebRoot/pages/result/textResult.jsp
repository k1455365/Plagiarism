<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<script type="text/javascript" src="/Plagiarism_Detection/js/layout.js"></script>
<link rel="stylesheet" type="text/css"
	href="/Plagiarism_Detection/css/result.css" />
<title>resultDetail</title>
<script type="text/javascript">
	function configTrg() {
		var flag = document.getElementById('flag').innerHTML;
		if (flag == 0) {
			alert("no result");
		} else {
		}
		var trgCode = document.getElementById('trgRaw').innerHTML;
		trg = new Array;
		//alert("trg file is: "+trgCode);
		trg = trgCode.split(" ");
		//alert("trg after process is: "+trg);
		trg = matchLine(trg);//the result could be different in different browser
		sim = new Array;
		var sim = document.getElementById('simRaw').innerHTML;
		/* alert("similiar pairs are: "+sim); */
		simRecord = sim.split("#");
		/* alert(simRecord); */
		block = new Array;
		for ( var i = 0; i < simRecord.length-1; i++) {
			block = simRecord[i].split("&amp;");
			//get startline and endline
			/* alert(block); */
			srcBlock = new Array;
			srcBlock[i] = block[1];
			/* alert("here"+srcBlock[i] ); */
			var blockString = srcBlock[i].toString();//变成字符串
			var blockLen = blockString.length;
			
			blockStr = blockString.split("]");
			blockString = blockStr[0];
			blockString = blockString.substring(1, blockLen);//截取1到len-1的字符串
			line = new Array;
			line = blockString.split(",");//用，分成两个；第一个是startline第二个是endline
			startLine = line[0];
			endLine = line[1];
			
			//configure style of source block
			/* alert ("Start line is: "+startLine+" and endline is: "+endLine); */
			for ( var n = (startLine - 1); n < endLine; n++) {
				trg[n] = "<span style=\"color:red\">•</span>" + trg[n];
			}
			n = startLine - 1;
			trg[n] = "<a  id=\"B" + i + "\"class=\"a4"
					+ "\" onclick=\"blendent(" + i
					+ ")\" onmouseover=\"change(" + i
					+ ")\" onmouseout=\"recover(" + i + ")\" name=\"code_" + i
					+ "\">" + trg[n];
			n = endLine - 1;
			trg[n] = trg[n] + "</a>";
		}
		/* alert("trg after process: "+trg); */
		/* trgFinal = addLinenum(trg); */
		trgFinal = trg;
		//-------------------------------deal with the first file-------------------------------
		var srcCode = document.getElementById('srcRaw').innerHTML;
	/* 	alert("src file is: "+srcCode); */
		src = new Array;
		src = srcCode.split(" ");
		src = matchLine(src);
		sim = new Array;
		var sim = document.getElementById('simRaw').innerHTML;
		alert(sim);
		simRecord = sim.split("#");
		block = new Array;
		for ( var i = 0; i < simRecord.length-1; i++) {
			block = simRecord[i].split("&amp;");
			// get startline and endline
			srcBlock = new Array;
			srcBlock[i] = block[0];
			var blockString = srcBlock[i].toString();// 变成字符串
			var blockLen = blockString.length;
			blockStr = blockString.split("]");
			blockString = blockStr[0];
			alert(blockLen);
			blockString = blockString.substring(1, blockLen);//截取1到len-1的字符串
			
			line = new Array;
			
			line = blockString.split(",");// 用，分成两个；第一个是startline第二个是endline
			startLine = line[0];
			endLine = line[1];
			alert ("Start line is: "+startLine+" and endline is: "+endLine);
			// configure style of target block
			for ( var n = (startLine - 1); n < endLine; n++) {
				src[n] = "<span style=\"color:red\">•</span>" + src[n];
			}
			m = startLine - 1;
			alert(m);
			src[m] = "<a href=\"#B" + i + "\"class=\"a4"
					+ "\" onclick=\"blendent(" + i
					+ ")\" onmouseover=\"change(" + i
					+ ")\" onmouseout=\"recover(" + i + ")\" name=\"code_" + i
					+ "\">" + src[m];
			m = endLine - 1;
			src[m] = src[m] + "</a>";
		}
		/* srcFinal = addLinenum(src); *///and line num for code
		srcFinal =src;
		/* get basic information of those two file */
		var simResult = document.getElementById('simResult').innerHTML;
		var trgFile = document.getElementById('trgFile').innerHTML;
		var srcFile = document.getElementById('srcFile').innerHTML;
		/*var rect=layout();
		var width=rect[0];
		var height=rect[1];
				alert(width);
		alert(height);
		height: "+height+"px;*/
		var width = layout();
		var decoratedPage = "<html><head>"
				+ "<script src=\"/Plagiarism_Detection/js/jquery-1.8.0.js\"></s"+"cript>"
				+ "<script type=\"text/javascript\" src=\"/Plagiarism_Detection/js/layout.js\"></s"+"cript>"
				+ "<script type=\"text/javascript\"></s"+"cript>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"/Plagiarism_Detection/css/a1.css\" />"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"/Plagiarism_Detection/css/a2.css\" />"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"/Plagiarism_Detection/css/a3.css\" />"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"/Plagiarism_Detection/css/a4.css\" />"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"/Plagiarism_Detection/css/result.css\" /></head>"
				+ "<body ><table><tr><td class=\"td_top\" colspan=\"4\" ><p class=\"p_title\" >Text Plagiarism Detection Result"
				+ "</p>"
				+ "<p class=\"p_data\" >score："
				+ simResult
				+ "</p><p class=\"return\"><a href=\"#\"class=\"white\" onclick=\"showTable()\">"
				+ "<img alt=\"\" src=\"/webcmp/images/table.png\" />Check the similiar pairs</a>"
				+ "<span>&nbsp</span><a class=\"white\" href=\"\">"
				+ "<img alt=\"\" src=\"/webcmp/images/back.png\" /> Back</a></p></td></tr><tr bgcolor=\"#FFFFF5\"><td class=\"td_midTitle\">File Name：</td>"
				+ "<td class=\"td_midData\">"
				+ srcFile
				+ "</td><td class=\"td_midTitle\">File Name:</td>"
				+ "<td class=\"td_midData\">"
				+ trgFile
				+ "</td></tr><tr><td colspan=\"2\"><div style=\"width: "+width+"px;\">"
				+ srcFinal
				+ "</div></td><td class=\"td_code\" colspan=\"2\"><div style=\"width: "+width+"px;\">"
				+ trgFinal + "</div></td></tr></table></body></html>";
		document.writeln(decoratedPage);
		sim = createTable(sim);
	}
</script>
</head>

<body onload="configTrg()">
	<!-- get the type of task -->
	<div id="flag" style="display:none">
		<s:property value="taskway" />
	</div>
	<!-- 源代码获取 -->
	<div id="srcRaw" style="display:none">
		<pre>
				<s:property value="srccontent" />
			</pre>
	</div>
	<!-- 目标代码获取 -->
	<div id="trgRaw" style="display:none">
		<pre>
				<s:property value="trgcontent" />
			</pre>
	</div>
	<!-- 相似关系获取 -->
	<div id="simRaw" style="display:none"><s:property value="Textresult" />
	</div>
	<!-- srcFileName -->
	<div id="srcFile" style="display:none">
		<s:property value="srcfile" />
	</div>
	<!-- trgFileName -->
	<div id="trgFile" style="display:none">
		<s:property value="trgfile" />
	</div>
	<!-- simResult -->
	<div id="simResult" style="display:none">
		<s:property value="textsim" />
	</div>
</body>

</html>
