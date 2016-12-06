<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>


<table id="dg" title="Student List">
	<thead>
		<tr>
			<th data-options="field:'sid',width:100,align:'center'">学生学号</th>
			<th data-options="field:'sname',width:100,align:'center'">姓名</th>
			<th data-options="field:'email',width:100,align:'center'">邮箱</th>
			<th data-options="field:'age',width:100,align:'center'">年龄</th>
		</tr>
	</thead>
</table>

//管理员模块的工具栏
<div id="manage_tool" style="padding:2px 5px;">
	<div style="margin-bottom:5px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manage_tool.add();">Add</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manage_tool.edit();">Update</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="manage_tool.remove();">Delete</a> 
		&nbsp;&nbsp;&nbsp;&nbsp;
		Search by name:<input type="text" class="textbox" name="search_manager" style="width:110px"> 
		Date From<input type="text" name="date_from" class="easyui-datebox" editable="false" style="width:110px"> 
		To：<input type="text" name="date_to" class="easyui-datebox" editable="false" style="width:110px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="manage_tool.search();">Search</a>
	</div>
</div>

<script type="text/javascript" src="<%=basePath%>js/student.js"></script>