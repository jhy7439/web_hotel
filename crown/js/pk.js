var scrollValue;
var tagImg =['../img/8126.jpg','../img/8132.png','../img/7867.png','../img/5648.png','../img/7920.jpg','../img/7867.png'];
var count=0;
$(function (){
	
		for(i=0;i<=5;i++){
			count++;
		$("#homeRoomPackageItem>div:nth-child("+count+")").append("<img src='"+tagImg[i]+"'/>");
		}
		
	$(window).scroll(function (){
			scrollValue = $(document).scrollTop();
		
	if(scrollValue>=200){
		
		$("#crown>img").attr("src","../img/logo2.PNG");
		$("#crown>img").css("width","90%").css("height","50px");
		$("#menubar>li").css("width","15.8%").css("float","left");
		$("#menubar>li:nth-child(4)").css("width","50px");
		$("#menubar>li").css("text-align","center");
		
	}else if(scrollValue<200){
		
		$("#crown>img").attr("src","../img/logo1.PNG");
		$("#menubar>li").css("width","13.7%").css("text-align","center").css("float","left").css("transition-duration","0.5s");
	}
	
	//3862
	
	if(scrollValue>=1966){
		$("#resPager").css("transform","translateY(-30px)").css("transition-duration","3s");
	}else if(scrollValue<1966){
		$("#resPager").css("transform","translateY(0px)").css("transition-duration","3s");
	}
	
	
	console.log(scrollValue);
	if(scrollValue>=600){
		//$("#moveImg").animate({marginTop:"30px"},"fast");
		//$("#moveImg").animate({transform:"translateY(30px)"});
		$("#homeRoomPackageItem>div:nth-child(1)>img").css("transform","translateY(30px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(1)>p").css("transform","translateX(-30px)").css("opacity","1").css("transition-duration","3s");
	}else if(scrollValue<600){
		//$("#moveImg").animate({marginTop:0},"fast");
		//$("#moveImg").animate({transform:"translateY(0px)"});
		$("#homeRoomPackageItem>div:nth-child(1)>img").css("transform","translateY(0px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(1)>p").css("transform","translateX(0px)").css("opacity","0").css("transition-duration","3s");
	}
	
	
	if(scrollValue>=1039){
		//$("#moveImg").animate({marginTop:"30px"},"fast");
		//$("#moveImg").animate({transform:"translateY(30px)"});
		$("#homeRoomPackageItem>div:nth-child(2)>img").css("transform","translateY(30px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(2)>p").css("transform","translateX(30px)").css("opacity","1").css("transition-duration","3s");
	}else if(scrollValue<1039){
		//$("#moveImg").animate({marginTop:0},"fast");
		//$("#moveImg").animate({transform:"translateY(0px)"});
		$("#homeRoomPackageItem>div:nth-child(2)>img").css("transform","translateY(0px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(2)>p").css("transform","translateX(0px)").css("opacity","0").css("transition-duration","3s");
	}
	if(scrollValue>=1839){
		//$("#moveImg").animate({marginTop:"30px"},"fast");
		//$("#moveImg").animate({transform:"translateY(30px)"});
		$("#homeRoomPackageItem>div:nth-child(3)>img").css("transform","translateY(30px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(3)>p").css("transform","translateX(-30px)").css("opacity","1").css("transition-duration","3s");
	}else if(scrollValue<1839){
		//$("#moveImg").animate({marginTop:0},"fast");
		//$("#moveImg").animate({transform:"translateY(0px)"});
		$("#homeRoomPackageItem>div:nth-child(3)>img").css("transform","translateY(0px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(3)>p").css("transform","translateX(0px)").css("opacity","0").css("transition-duration","3s");
	}
	
	
	if(scrollValue>=2379){
		//$("#moveImg").animate({marginTop:"30px"},"fast");
		//$("#moveImg").animate({transform:"translateY(30px)"});
		$("#homeRoomPackageItem>div:nth-child(4)>img").css("transform","translateY(30px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(4)>p").css("transform","translateX(30px)").css("opacity","1").css("transition-duration","3s");
	}else if(scrollValue<2379){
		//$("#moveImg").animate({marginTop:0},"fast");
		//$("#moveImg").animate({transform:"translateY(0px)"});
		$("#homeRoomPackageItem>div:nth-child(4)>img").css("transform","translateY(0px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(4)>p").css("transform","translateX(0px)").css("opacity","0").css("transition-duration","3s");
	}
	if(scrollValue>=2979){
		//$("#moveImg").animate({marginTop:"30px"},"fast");
		//$("#moveImg").animate({transform:"translateY(30px)"});
		$("#homeRoomPackageItem>div:nth-child(5)>img").css("transform","translateY(30px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(5)>p").css("transform","translateX(-30px)").css("opacity","1").css("transition-duration","3s");
	}else if(scrollValue<2979){
		//$("#moveImg").animate({marginTop:0},"fast");
		//$("#moveImg").animate({transform:"translateY(0px)"});
		$("#homeRoomPackageItem>div:nth-child(5)>img").css("transform","translateY(0px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(5)>p").css("transform","translateX(0px)").css("opacity","0").css("transition-duration","3s");
	}
	
	
	if(scrollValue>=3579){
		//$("#moveImg").animate({marginTop:"30px"},"fast");
		//$("#moveImg").animate({transform:"translateY(30px)"});
		$("#homeRoomPackageItem>div:nth-child(6)>img").css("transform","translateY(30px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(6)>p").css("transform","translateX(30px)").css("opacity","1").css("transition-duration","3s");
	}else if(scrollValue<3579){
		//$("#moveImg").animate({marginTop:0},"fast");
		//$("#moveImg").animate({transform:"translateY(0px)"});
		$("#homeRoomPackageItem>div:nth-child(6)>img").css("transform","translateY(0px)").css("transition-duration","3s");
		$("#homeRoomPackageItem>div:nth-child(6)>p").css("transform","translateX(0px)").css("opacity","0").css("transition-duration","3s");
	}
	
	
	
	
	});
});
	
	
//	$("#moveImg").animate({marginTop:"30px"},2000);
	//$("#RoomPackageDescription").animate({opacity:1},3000);	






