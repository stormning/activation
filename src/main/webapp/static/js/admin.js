(function($) {
	$(function() {
		$(".requestBtn").click(function() {
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
						$(".verifycode").each(function(){
							$(this).html(res.verifycode);
						});
						$(".alert-danger").hide();
						$(".alert-info").hide();
						$(".alert-success").show();
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
						default:
							_errorMsg = "未知错误";
							break;
						}
						$(".alert-info").hide();
						$(".alert-success").hide();
						$(".alert-danger").find(".msg").html(_errorMsg).end().show();
					}
					$(".requestBtn").button("complete");
				}, 500);
			});
		});
	});
})($);