$(function(){
	$('#log-out').click(function() {
		// 清除session
		$.ajax({
			url : "/myO2O/person/logout",
			type : "post",
			async : false,
			cache : false,
			dataType : 'json',
			success : function(data) {
				if (data.success) {
					window.location.href = "/myO2O/personadmin/login";
					return false;
				}
			},
			error : function(data, error) {
				alert(error);
			}
		});
		
	});
})