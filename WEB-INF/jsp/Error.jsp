<%@ page contentType="text/html; charset=utf8" isErrorPage="true"%>
<%
	String error = (String)request.getAttribute("error");
%>
<html>
<head>
<title>Film Information System</title>
</head>
<body>
<div>
<h2>エラー画面</h2>
<table border="1">
<%
	if(error != null){
		out.println("<tr><td>" + error + "</td></tr>");
	}
	if(exception != null){
		out.println("<tr><td>" + exception.getMessage() + "</td></tr>");
	}
%>
</table>
</div>
</body>
</html>
