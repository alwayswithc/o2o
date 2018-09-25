$(function(){
	$('#submit').click(function() {
		var person = {};
		// 获取表单里的数据并填充进对应的用户属性中
		var name = $('#name').val();
		var password = $('#password').val();
		var userType=$('#userType').val();
		$.ajax({
			url : '/myO2O/person/login',
			type : 'POST',
			data : {
				name : name,
				password : password,
				userType :userType,
			},
			dataType : 'json',
			success : function(data) {
				if (data.success) {
					 window.location.href=data.url;
			    } else {
			        alert(data.errMsg);
			    }
			}
		});
		
	});
	
})