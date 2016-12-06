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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
  </head>
  <body class="easyui-layout">
     <!-- 项目页面头信息 -->
    <div data-options="region:'north'" style="height:60px; background-color: #add8e6;" >
        <div class="logo">Demo System</div>
        <div class="logout">Welcome: <%=session.getAttribute("admin") %> | <a name="logout">Logout</a></div>
    </div>

    <!-- 项目页面导航信息-->
    <div data-options="region:'west',split:true,iconCls:'icon-tip'" title="Navigation" style="width:180px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="User Management" style="padding:10px;" data-options="selected:true">
                <ul id="nav" class="easyui-tree"></ul>
            </div>
            <div title="Product Management" style="padding:10px;">
                content2
            </div>
            <div title="System Report" style="padding:10px">
                content3
            </div>
        </div>
    </div>

    <!-- 项目页主内容界面-->
    <div data-options="region:'center',title:'Main Content',iconCls:'icon-ok'">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
        	<!-- 项目About界面-->
            <div title="About" data-options="href:'_content.html', iconCls:'icon-help'" style="padding:10px"></div>

    </div>
  </body>
<script type="text/javascript" src="<%=basePath%>js/framework/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/framework/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
</html>
