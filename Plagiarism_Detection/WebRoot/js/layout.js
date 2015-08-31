function layout() {
	browserName = judgeBrowser();
	switch (browserName) {
	case "Chrome": {
		var width = document.body.clientWidth;
		var width = ((0.5 * width) - 3);
		/*a=window.document.getElementsByClassName("td_midTitle");
		alert(a[0].style.height);
		a[0].style.height="3%";
		a[1].style.height="3%";
		b=window.document.getElementsByClassName("td_midData");
		b[0].style.height="3%";
		b[1].style.height="3%";*/
		break;
	}
	case "Microsoft Internet Explorer": {
		/*
		 * alert("网页正文部分上："+window.screenTop +
		 * "网页被卷去的高："+document.body.scrollTop +
		 * "网页可见区域高："+document.body.offsetHeight+
		 * "网页可见区域高："+document.body.clientHeight +
		 * "网页正文全文高："+document.body.scrollHeight+
		 * "屏幕分辨率的高："+window.screen.height +
		 * "屏幕可用工作区高度："+window.screen.availHeight);
		 */
		var width = 0.5 * (window.screen.availWidth - window.screenLeft - 12);
		/*
		 * var
		 * height=window.screen.availHeight-window.screenTop-document.body.offsetHeight;
		 * var rect=new array; rect[0]=width; rect[1]=height
		 */
		break;
	}
	case "Firefox": {
		// var height=window.screen.availHeight-255;
		/*alert("网页正文部分上：" + window.screenTop + "网页被卷去的高："
				+ document.body.scrollTop + "网页可见区域高："
				+ document.body.offsetHeight + "网页可见区域高："
				+ document.body.clientHeight + "网页正文全文高："
				+ document.body.scrollHeight + "屏幕分辨率的高："
				+ window.screen.height + "屏幕可用工作区高度："
				+ window.screen.availHeight);*/
		var width = 620;
		/*
		 * var height=650; var rect=new array; rect[0]=width; rect[1]=height
		 */
		break;
	}
	}
	// return rect;
	return width;
}
function judgeBrowser() {
	var agentInfo = navigator.userAgent;
	if (agentInfo.indexOf("MSIE") > 0) {
		browser = "Microsoft Internet Explorer";
	} else if (agentInfo.indexOf("Firefox") > 0) {
		browser = "Firefox";
	} else if (agentInfo.indexOf("Chrome") > 0) {
		browser = "Chrome";
	} else {
		browser = "safari";
	}
	return browser;
}
function change(b) {
	a = window.document.getElementsByName("code_" + b);
	a[0].style.background = "#FFFFE5";
}
function recover(b) {
	a = window.document.getElementsByName("code_" + b);
	a[0].style.background = "#F0F4FA";
}
function matchLine(code) {
	browserName = navigator.appName;
	switch (browserName) {
	case "Netscape": {
		code.splice(0, 1);
		break;
	}
	case "Microsoft Internet Explorer": {

		break;
	}
	case "Mozilla Firefox": {
		break;
	}
	}
	return code;
}
//delete useless part of file directory
function filename(filename){
	names=filename.split("/");
	name=names[names.length-1];
	return name;
}
function blackOther(x){
	links = document.all.tags("A");
	total = links.length;
	for(var i=1;i<total;i++){
		if(i!=x){
			s = window.document.getElementsByName("code_" + i);
			s[0].className = "a4";
			s[1].className = "a4";
		}
	}
}
function blendent(m) {
	n = m % 3;
	switch (n) {
	case 0: {
		var s = window.document.getElementsByName("code_" + m);
		s[0].className = "a1";
		s[1].className = "a1";
		blackOther(m);
		break;
	}
	case 1: {
		var s = window.document.getElementsByName("code_" + m);
		s[0].className = "a2";
		s[1].className = "a2";
		blackOther(m);
		break;
	}
	case 2: {
		var s = window.document.getElementsByName("code_" + m);
		//alert(s.length);
		s[0].className = "a3";
		s[1].className = "a3";
		blackOther(m);
		break;
	}
	}
}

function addLinenum(code) {
	var codeFinal = "&nbsp";
	for ( var x = 0; x < code.length; x++) {
		code[0] = "<pre class=\"linenum\"><span>&nbsp&nbsp&nbsp" + (x + 1)
				+ "&nbsp</span> " + code[0];
		if (x < 9 & x > 0) {
			code[x] = "<span>&nbsp&nbsp&nbsp" + (x + 1) + "&nbsp</span> "
					+ code[x] + "<br>";
			var temp = code[x].toString();
			codeFinal = codeFinal + temp;
		} else if (x > 8 & x < 100) {
			code[x] = "<span>&nbsp&nbsp" + (x + 1) + "&nbsp</span>" + code[x]
					+ "<br>";
			var temp = code[x].toString();
			codeFinal = codeFinal + temp;
		} else if (x > 98 & x < 1000) {
			code[x] = "<span>&nbsp" + (x + 1) + "&nbsp</span>" + code[x]
					+ "<br>";
			var temp = code[x].toString();
			codeFinal = codeFinal + temp;
		} else if (x > 998 & x < 10000) {
			code[x] = "<span>" + (x + 1) + "&nbsp</span>" + code[x] + "<br>";
			var temp = code[x].toString();
			codeFinal = codeFinal + temp;
		} else {
			code[x] = "<span>" + "&nbsp</span>" + code[x] + "<br>";
			var temp = code[x].toString();
			codeFinal = codeFinal + temp;
		}
	}
	return codeFinal;
}
function myToString(code) {
	var codeFinal = "&nbsp";
	for ( var x = 0; x < code.length; x++) {
			var temp = code[x].toString();
			codeFinal = codeFinal+ " " + temp;
	}
	return codeFinal
}
function createTable(a){
window.table=a;
//return table;
}
function showTable(){
	var sim=table;	
	simRecord = sim.split("#");
	block = new Array;
	var content="详细相似对记录：\n";
	for ( var i = 1; i < simRecord.length; i++) {
		block = simRecord[i].split("&amp;");
		srcBlock = new Array;
		srcBlock[i] = block[0];
		var blockString = srcBlock[i].toString();// 变成字符串
		var blockLen = blockString.length;
		blockStr = blockString.split("]");
		blockString = blockStr[0];
		blockString = blockString.substring(1, blockLen);//截取1到len-1的字符串
		srcline = new Array;
		srcline = blockString.split(",");// 用，分成两个；第一个是startline第二个是endline
		srcStartLine = srcline[0];
		srcEndLine = srcline[1];
		
		trgBlock = new Array;
		trgBlock[i] = block[1];
		var blockString = trgBlock[i].toString();//变成字符串
		var blockLen = blockString.length;
		blockStr = blockString.split("]");
		blockString = blockStr[0];
		blockString = blockString.substring(1, blockLen);//截取1到len-1的字符串
		trgline = new Array;
		trgline = blockString.split(",");//用，分成两个；第一个是startline第二个是endline
		trgStartLine = trgline[0];
		trgEndLine = trgline[1];
		content=content+"检测文件："+srcStartLine+"——"+srcEndLine+"，  样本文件："+trgStartLine+"——"+trgEndLine+"；\n";
	}
	alert(content);
}
// $(document).ready(function(){
// $('# a').click(function(){
// alert("enter");
// $('html,body').animate({scrollTop:$('#B1').offset().top}, 1000);
// });
// return false;
// });
/*
 * $(document).ready(function(){ $("a[href^=#]").click(function(){
 * alert("here"); var href = $(this).attr("href"); var pos =
 * $(href).offset().top; $("html,body").animate({scrollTop: pos}, 1000); return
 * false; }) })
 * 
 * $('a[href*=#]').click(function() { if (location.pathname.replace(/^\//,'') ==
 * this.pathname.replace(/^\//,'') && location.hostname == this.hostname) { var
 * $target = $(this.hash); $target = $target.length && $target || $('[name=' +
 * this.hash.slice(1) +']'); if ($target.length) { var targetOffset =
 * $target.offset().top; var obj = document.documentElement; if
 * (jQuery.browser.safari) obj = document.body if (jQuery.browser.msie) obj =
 * 'html'; $(obj).animate({scrollTop: targetOffset}, 1000); return false; } }
 * });
 */