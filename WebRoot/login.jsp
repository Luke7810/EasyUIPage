<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/framework/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/framework/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css" />

</head>

<body>
	<div id="login">
		<p>
			Admin Name:<input type="text" id="adminname" name="adminname" class="textbox">
		</p>
		<p>
			Password: <input type="password" id="adminpwd" name="adminpwd" class="textbox">
		</p>
	</div>

	<div id="btn">
		<a href="#" class="easyui-linkbutton">Login</a>
	</div>
</body>
<script type="text/javascript"
	src="<%=basePath%>js/framework/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/framework/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login.js"></script>
</html>
