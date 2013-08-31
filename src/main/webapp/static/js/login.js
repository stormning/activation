(function($) {
	$(function(){
		$("#loginForm").on("submit",function(e){
			e.preventDefault();
			var btn = $("#loginForm buttom[type=submit]");
			btn.button("loading");
			$(".text-danger").hide();
			var _f = $(this);
			var _username = _f.find("input[name=username]");
			var _password = _f.find("input[name=password]");
			if(!$.trim(_username.val())||!$.trim(_password.val())){
				$(".text-danger").html("用户名,密码不能为空").fadeIn();
			}else{
				$.post(_f.attr("action"),_f.serializeArray(),function(res){
					if(res.success=="1"){
						location.href = _f.attr("successUrl");
					}else{
						$(".text-danger").html("用户名或密码错误").fadeIn();
						btn.button("complete");
					}
				});
			}
		});
	});
})($);