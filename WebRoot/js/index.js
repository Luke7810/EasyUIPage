$(function() {
	$("a[name='logout']")
			.click(
					function() {
						$
								.ajax({
									url : 'logoutAction',
									type : 'POST',
									data : {},
									beforeSend : function() {
										$.messager.progress({
											text : 'logout... ...',
										});
									},
									success : function(data, response, status) {
										$.messager.progress('close');
										if (data > 0) {
											location.href = 'login.jsp';
										} else {
											$.messager
													.alert(
															'logout failed！',
															'logout error, please close the application!',
															'warning',
															function() {
															});
										}
									}
								});
					});

	// tree 结构
	$('#nav').tree({
		url : 'data/tree_data1.json',
		method: 'get',
		animate:true,
		dnd: true,
		lines : true,
		onLoadSuccess : function(node, data) {
			var _this = this;
			if (data) {
				$(data).each(function(index, value) {
					if (this.state == 'closed') {
						$(_this).tree('expandAll');
					}
				});
			}
		},
		onClick : function(node) {
			if (node.url) {
				if ($('#tabs').tabs('exists', node.text)) {
					$('#tabs').tabs('select', node.text)
				} else {
					$('#tabs').tabs('add', {
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						href : node.url + '.jsp',
					});
				}
			}
		}
	});
	
	
	
});