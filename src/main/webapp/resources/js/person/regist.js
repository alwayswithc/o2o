 $(function() {
	// 提交按钮的事件响应
	$('#submit').click(function() {
		var person = {};
		// 获取表单里的数据并填充进对应的用户属性中
		person.name = $('#name').val();
		person.password = $('#password').val();
		person.email = $('#email').val();
		person.gender=$('#gender').val();
		// 生成表单对象，用于接收参数并传递给后台
		var formData = new FormData();
		formData.append('personStr', JSON.stringify(person));
		// 获取表单里输入的验证码
		var verifyCodeActual = $('#j_captcha').val();
		if (!verifyCodeActual) {
			$.toast('请输入验证码！');
			return;
		}
		formData.append('verifyCodeActual', verifyCodeActual);
		// 将数据提交至后台处理相关操作
		$.ajax({
			url : '/myO2O/person/regist',
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('提交成功！');
					window.location.href = '/myO2O/personadmin/login';
				}
				// 点击验证码图片的时候，注册码会改变
				$('#captcha_img').click();
			}

		});
	});
})
