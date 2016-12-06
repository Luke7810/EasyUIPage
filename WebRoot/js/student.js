$(function() {
	$("#dg").datagrid({
		url: 'stulist.action',
		fit : true,
		fitColumns : true,
		striped : true,
		rownumbers : true,
		singleSelect:true,
		pagination:true,
		pageSize : 5,
		pageList : [ 5, 10, 15, 20 ],
		method:'get',
		toolbar : '#manage_tool'
	}).datagrid('getPager');
	
	
	
});