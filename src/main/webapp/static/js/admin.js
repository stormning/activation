(function($) {
	$(function() {
		$(".requestBtn").click(function() {
			$(".verifycode").html("");
			var _errorMsg;
			var _f = $(".activation-form form");
			if(!(_f.find("input[name=cardNo]").val()&&_f.find("input[name=password]").val()&&_f.find("input[name=hardCode]").val())){
				_errorMsg = "卡号、密码、机器码为必填项目";
				$(".alert-info").hide();
				$(".alert-success").hide();
				$(".alert-danger").find(".msg").html(_errorMsg).end().show();
				return;
			}
			$(".requestBtn").button("loading");
			$.post(_f.attr("action"), _f.serializeArray(), function(res) {
				setTimeout(function(){
					if (res.success=="1") {
						$(".verifycode").html(res.verifyCode);
						$(".alert-danger").hide();
						$(".alert-info").hide();
						$(".alert-success").show();
						if(param.superadmin){
							$("#recordHolder").load(param.recordUrl);
						}
					} else {
						switch (res.errorCode) {
						case "0":
							_errorMsg = "卡号或密码错误!";
							break;
						case "1":
							_errorMsg = "该卡已经被激活过!";
							break;
						case "2":
							_errorMsg = "该卡已经过期!";
							break;
						case "3":
							_errorMsg = "学习卡对应的学科不存在!";
							break;
						case "4":
							_errorMsg = "没有权限激活该学段的课程!";
							break;	
						default:
							_errorMsg = "网络异常请重试";
							break;
						}
						$(".alert-info").hide();
						$(".alert-success").hide();
						$(".alert-danger").find(".msg").html(_errorMsg).end().show();
					}
					$(".requestBtn").button("complete");
				}, 300);
			});
		});
		if(param.superadmin){
			$("#recordHolder").load(param.recordUrl);
		}
	});
})($);