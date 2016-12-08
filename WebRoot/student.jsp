<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!-- Student datagrid list  -->
<table id="dg" title="Student List">
	<thead data-options="frozen:true">
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>
                    <th data-options="field:'id',width:100,align:'center'">ID</th>
                </tr>
            </thead>
	<thead>
		<tr>
			<th data-options="field:'sid',width:100,align:'center'">学生学号</th>
			<th data-options="field:'sname',width:100,align:'center'">姓名</th>
			<th data-options="field:'email',width:100,align:'center'">邮箱</th>
			<th data-options="field:'age',width:100,align:'center'">年龄</th>
		</tr>
	</thead>
</table>

<!-- datagrid 工具栏 -->
<div id="manage_tool" style="padding:2px 5px;">
	<div style="margin-bottom:5px;">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="manage_tool.add();">Add</a> 
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manage_tool.edit();">Update</a> 
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="manage_tool.remove();">Delete</a> 
		&nbsp;&nbsp;&nbsp;&nbsp;
		Search by name:<input type="text" class="textbox" name="search_manager" style="width:110px"> 
		Date From<input type="text" name="date_from" class="easyui-datebox" editable="false" style="width:110px"> 
		To：<input type="text" name="date_to" class="easyui-datebox" editable="false" style="width:110px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="manage_tool.search();">Search</a>
	</div>
</div>

<!-- Student 的添加界面 -->
<form id="student_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
	<p>Student S_ID <input type="text" name="sid" class="textbox" style="width:200px;"></p>
	<p>Student Name <input type="text" name="sname" class="textbox" style="width:200px;"></p>
	<p>Student Age  <input type="text" name="age" class="textbox" style="width:200px;"></p>
	<p>Student Email<input type="text" name="email" class="textbox" style="width:200px;"></p>
</form>

<!-- Student 的修改界面 -->
<form id="student_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
	<input type="hidden" name="id" class="textbox" style="width:200px;">
	<p>Student S_ID <input type="text" name="sid_edit" disabled="true" class="textbox" style="width:200px;"></p>
	<p>Student Name <input type="text" name="sname_edit" class="textbox" style="width:200px;"></p>
	<p>Student Age <input type="text" name="age_edit" class="textbox" style="width:200px;"></p>
	<p>Student Email <input type="text" name="email_edit" class="textbox" style="width:200px;"></p>
</form>


<script type="text/javascript" src="<%=basePath%>js/student.js"></script>