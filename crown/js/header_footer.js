var scrollValue;
$(function (){
	$("#menubar>li").hover(function(){
		
		
		$(this).children("ul").css("display","block");
		
	},function(){
		$(this).children("ul").css("display","none");
	});
	
	
	
	$(window).scroll(function (){
		scrollValue = $(document).scrollTop();
	
if(scrollValue>=200){
	
	$("#crown>a>img").attr("src","../img/logo2.PNG");
	$("#crown>a>img").css("width","90%").css("height","50px");
	$("#menubar>li").css("width","15.8%").css("float","left");
	$("#menubar>li:nth-child(4)").css("width","50px");
	$("#menubar>li").css("text-align","center");
	
}else if(scrollValue<200){
	
	$("#crown>a>img").attr("src","../img/logo1.PNG");
	$("#menubar>li").css("width","13.7%").css("text-align","center").css("float","left").css("transition-duration","0.5s");
}
	});
});


