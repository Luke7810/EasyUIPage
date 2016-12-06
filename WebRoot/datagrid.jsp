<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/framework/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/framework/themes/icon.css">
	
	<script type="text/javascript" src="<%=basePath%>js/framework/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/framework/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/student.js"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <table id="dg" title="Custom DataGrid Pager" 
			>
		<thead>
			<tr>
				<th data-options="field:'sid',width:100,align:'center'">学生学号</th>  
                <th data-options="field:'sname',width:100,align:'center'">姓名</th>  
                <th data-options="field:'email',width:100,align:'center'">邮箱</th>  
                <th data-options="field:'age',width:100,align:'center'">年龄</th>
			</tr>
		</thead>
	</table>
     
  </body>
</html>