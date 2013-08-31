(function($){
	$(function(){
		$(".pagination li[class!=active] a").click(function(e){
			e.preventDefault();
			$("#recordHolder").load(param.recordUrl,{'page.page':$(this).attr("page")});
		});	
	});
})($);