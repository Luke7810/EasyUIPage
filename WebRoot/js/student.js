
$(function() {
	//---list all student datagrid-------
	$("#dg").datagrid({
		url: 'stulist.action',
		toolbar : '#manage_tool',
		fit: true,   //自适应大小
        pageSize: 5,//默认选择的分页是每页5行数据
        pageList: [5, 10, 15, 20],//可以选择的分页集合
        nowrap: true,//设置为true，当数据长度超出列宽时将会自动截取
        striped: true,//设置为true将交替显示行背景。
        collapsible: true,//显示可折叠按钮
        selectOnCheck: true, //点击复选框则高亮该行
        checkOnSelect: false, //点击行任意位置表示选择了改行
        loadMsg: 'data loading......',
        singleSelect: false,//为true时只能选择单行
        fitColumns: true,//允许表格自动缩放，以适应父容器
        //sortName : 'xh',//当数据表格初始化时以哪一列来排序
        //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
        remoteSort: false,
        pagination: true,//分页
        rownumbers: true, //行数
        //以下code完成高亮显示的一些bug
        onClickCell: function (rowIndex, field, value) {
            IsCheckFlag = false;
        },

        onSelect: function (rowIndex, rowData) {

            if (typeof(IsCheckFlag)=="undefined" || !IsCheckFlag) {
                IsCheckFlag = true;
                $("#dg").datagrid("unselectRow", rowIndex);
            }
        },

        onUnselect: function (rowIndex, rowData) {
            if (typeof(IsCheckFlag)=="undefined" ||!IsCheckFlag) {
                IsCheckFlag = true;
                $("#dg").datagrid("selectRow", rowIndex);
            }
        }
	}).datagrid('getPager');
	
	//------show add student form--------
	$('#student_add').dialog({
		width : 350,
		title : 'add new student',
		modal : true,
		closed : true,
		iconCls : 'icon-add',
		buttons : [{
			text : 'Submit',
			iconCls : 'icon-save',
			handler : function () {
				if ($('#student_add').form('validate')) {
					//-------Ajax add a new user--------
					$.ajax({
						url : 'addStudent.action',
						type : 'post',
						data: {
							sid:   $('input[name="sid"]').val(),
							sname: $('input[name="sname"]').val(),
							age:   $('input[name="age"]').val(),
							email: $('input[name="email"]').val()
						},
						//-----before send message--------
						beforeSend : function () {
							$.messager.progress({
								text : 'Adding the student...',
							});
						},
						//-----check the return value----------
						success : function (data, response, status) {
							$.messager.progress('close');
							
							if(data > 0) {
								$.messager.show({
									title : 'Alert',
									msg : 'Added a new Student!',
								});
								$('#student_add').dialog('close').form('reset');
								$('#dg').datagrid('reload');
							}else{
								$.messager.alert('Added failed!', 'Can not added a new studend, please try again!', 'warning');
							}
						}
					});
					//----------------------------------
				}	
			},
		},{
			text : 'Cancel',
			iconCls : 'icon-undo',
			handler : function () {
				$('#student_add').dialog('close').form('reset');
			},
		}],
	});
	
	//--------show edit student form--------------------
	$('#student_edit').dialog({
		width : 350,
		title : 'add new student',
		modal : true,
		closed : true,
		iconCls : 'icon-edit',
		buttons : [{
			text : 'Submit',
			iconCls : 'icon-save',
			handler : function () {
				if ($('#student_edit').form('validate')) {
					//-------Ajax add a new user--------
					$.ajax({
						url : 'updateStudent.action',
						type : 'post',
						data: {
							id:		$('input[name="sid_edit"]').val(),
							sid:	$('input[name="sid_edit"]').val(),
							sname:	$('input[name="sname_edit"]').val(),
							age:	$('input[name="age_edit"]').val(),
							email:	$('input[name="email_edit"]').val()
						},
						//-----before send message--------
						beforeSend : function () {
							$.messager.progress({
								text : 'Updating the student...',
							});
						},
						//-----check the return value----------
						success : function (data, response, status) {
							$.messager.progress('close');
							
							if(data > 0) {
								$.messager.show({
									title : 'Alert',
									msg : 'Student information changed!',
								});
								$('#student_edit').dialog('close').form('reset');
								$('#dg').datagrid('reload');
							}else{
								$.messager.alert('Update failed!', 'Can not updated this studend, please try again!', 'warning');
							}
						}
					});
					//----------------------------------
				}
			},
		},{
			text : 'Cancel',
			iconCls : 'icon-undo',
			handler : function () {
				$('#student_edit').dialog('close').form('reset');
			},
		}],
	});
	
	//------validate sid--------------
	$('input[name="sid"]').validatebox({
		required : true,
		validType : 'length[2,20]',
		missingMessage : 'Please input S_ID',
		invalidMessage : 'S_ID leagth is between 2 to 20',
	});
	
	
	//------validate sname--------------
	$('input[name="sname"]').validatebox({
		required : true,
		validType : 'length[2,20]',
		missingMessage : 'Please input Student Name',
		invalidMessage : 'Student Name leagth is between 2 to 20',
	});
	
	//------validate sname in Edit--------------
	$('input[name="sname_edit"]').validatebox({
		required : true,
		validType : 'length[2,20]',
		missingMessage : 'Please input Student Name',
		invalidMessage : 'Student Name leagth is between 2 to 20',
	});
	
	//------validate age--------------
	$('input[name="age"]').validatebox({
		required : true,
		missingMessage : 'Please input Student age',
	});
	
	//------validate age in Edit--------------
	$('input[name="age_edit"]').validatebox({
		required : true,
		missingMessage : 'Please input Student age',
	});
	
	
	//-----Tool bar all JS code------------------
	manage_tool = {
			//----Tool bar click add ------------------
			add : function () {
				$('#student_add').dialog('open');
				$('input[name="sid"]').focus();
			},
			//----- Tool bar click edit ---------------
			edit : function () {
				var rows = $('#dg').datagrid('getSelections');
				if (rows.length > 1) {
					$.messager.alert('Warning!', 'Please select just 1 item to edit!', 'warning');
				}else if(rows.length == 0){
					$.messager.alert('Warning!', 'Please select just 1 item to edit!', 'warning');
				}else if(rows.length == 1){
					$.ajax({
						url  : 'getStudent.action',
						type : 'post',
						dataType: "json",
						data : {
							id : rows[0].id,
						}, 
						//-----before send message--------
						beforeSend : function () {
							$.messager.progress({
								text : 'Loading student information...',
							});
						},
						//----get student information
						success : function (data, response, status) {
							$.messager.progress('close');
							if(data){
								//-----Open the edit form ------
								$('#student_edit').form('load', {
									id 			: data.student.id,
									sid_edit	: data.student.sid,
									sname_edit	: data.student.sname,
									age_edit	: data.student.age,
									email_edit	: data.student.email
									
								}).dialog('open');
								
							}else{
								$.messager.alert('Get information failed', 'Unknow reason failed, please try again!', 'warning');
							}
						},
						
					});
				}
			},
			
			//-------Tool bar delete click--------
			remove : function () {
				var rows = $('#dg').datagrid('getSelections');
				if (rows.length > 0) {
					$.messager.confirm('Confirm Action', 'Are you sure you want to delete items?', function () {
						var ids = [];
						for (var i = 0; i < rows.length; i ++) {
							ids.push(rows[i].id);
						}
						//console.log(ids.join(','));
						$.ajax({
							type : 'POST',
							url : 'deleteStudent.action',
							data : {
								ids : ids.join(','),
							},
							//-----before send message-------
							beforeSend : function () {
								$.messager.progress({
									text : 'Deleting student information...',
								});
							},
							//-----success delete ----------
							success : function (data) {
								$.messager.progress('close');
								if(data > 0) {
									$('#dg').datagrid('loaded');
									$('#dg').datagrid('load');
									$('#dg').datagrid('unselectAll');
									$.messager.show({
										title : 'Alert',
										msg : data + ' items have been deleted!',
									});
								}
							},
						});
					});
				}else{
					$.messager.alert('Delete Action Warning', 'Please select least one item to delete!', 'warning');
				}
			},
		};
	
});


