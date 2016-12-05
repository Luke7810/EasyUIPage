$(function() {

	// 登录界面
	$('#login').dialog({
		title : 'login',
		width : 300,
		height : 180,
		modal : true,
		iconCls : 'icon-login',
		buttons : '#btn',
	});

	// 管理员帐号验证
	$('#adminname').validatebox({
		required : true,
		missingMessage : 'please input admin name',
		invalidMessage : 'admin name is required',
	});

	// 管理员密码验证
	$('#adminpwd').validatebox({
		required : true,
		validType : 'length[3,30]',
		missingMessage : 'please input password',
		invalidMessage : 'password is required',
	});

	// 加载时判断验证
	if (!$('#adminname').validatebox('isValid')) {
		$('#adminname').focus();
	} else if (!$('#adminpwd').validatebox('isValid')) {
		$('#adminpwd').focus();
	}

	// 单击登录
	$('#btn a').click(
			function() {
				if (!$('#adminname').validatebox('isValid')) {
					$('#adminname').focus();
				} else if (!$('#adminpwd').validatebox('isValid')) {
					$('#adminpwd').focus();
				} else {
					$.ajax({
						url : 'loginAction',
						type : 'POST',
						data : {
							adminname : $('#adminname').val(),
							adminpwd : $('#adminpwd').val(),
						},
						beforeSend : function() {
							$.messager.progress({
								text : 'login... ...',
							});
						},
						success : function(data, response, status) {
							$.messager.progress('close');
							if (data > 0) {
								location.href = 'index.jsp';
							} else {
								$.messager.alert('login failed！', 'user name or password error!',
										'warning', function() {
											$('#password').select();
										});
							}
						}
					});
				}
			});

});